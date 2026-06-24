package com.laundryku.dao;

import com.laundryku.config.DatabaseConnection;
import com.laundryku.model.Pelanggan;
import com.laundryku.model.Pembayaran;
import com.laundryku.model.TransaksiLaundry;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// DAO untuk akses data pembayaran di database
public class PembayaranDAO {

    // Ambil semua pembayaran (dengan JOIN transaksi + pelanggan)
    public List<Pembayaran> findAll() throws SQLException {
        List<Pembayaran> list = new ArrayList<>();
        String sql = """
                SELECT b.id_pembayaran, b.tanggal_bayar, b.metode, b.jumlah_bayar, b.status AS status_bayar,
                       t.id_transaksi, t.tanggal_masuk, t.tanggal_selesai_est, t.status AS status_transaksi, t.total,
                       p.id_pelanggan, p.nama, p.no_hp, p.alamat
                FROM pembayaran b
                JOIN transaksi_laundry t ON t.id_transaksi = b.id_transaksi
                JOIN pelanggan p ON p.id_pelanggan = t.id_pelanggan
                ORDER BY b.id_pembayaran DESC
                """;
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                list.add(mapPembayaran(resultSet));
            }
        }
        return list;
    }

    // Simpan pembayaran baru (status LUNAS/BELUM_LUNAS dihitung otomatis)
    public void save(Pembayaran pembayaran) throws SQLException {
        String sql = "INSERT INTO pembayaran (id_transaksi, tanggal_bayar, metode, jumlah_bayar, status) VALUES (?, ?, ?, ?, ?)";
        pembayaran.tentukanStatus();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, pembayaran.getTransaksi().getIdTransaksi());
            statement.setDate(2, Date.valueOf(pembayaran.getTanggalBayar()));
            statement.setString(3, pembayaran.getMetode());
            statement.setBigDecimal(4, pembayaran.getJumlahBayar());
            statement.setString(5, pembayaran.getStatus());
            statement.executeUpdate();
        }
    }

    // Update data pembayaran
    public void update(Pembayaran pembayaran) throws SQLException {
        String sql = "UPDATE pembayaran SET tanggal_bayar = ?, metode = ?, jumlah_bayar = ?, status = ? WHERE id_pembayaran = ?";
        pembayaran.tentukanStatus();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, Date.valueOf(pembayaran.getTanggalBayar()));
            statement.setString(2, pembayaran.getMetode());
            statement.setBigDecimal(3, pembayaran.getJumlahBayar());
            statement.setString(4, pembayaran.getStatus());
            statement.setInt(5, pembayaran.getIdPembayaran());
            statement.executeUpdate();
        }
    }

    // Hapus pembayaran berdasarkan ID
    public void delete(int idPembayaran) throws SQLException {
        String sql = "DELETE FROM pembayaran WHERE id_pembayaran = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idPembayaran);
            statement.executeUpdate();
        }
    }

    // Mapping hasil query ke objek Pembayaran
    private Pembayaran mapPembayaran(ResultSet resultSet) throws SQLException {
        Pelanggan pelanggan = new Pelanggan(
                resultSet.getInt("id_pelanggan"),
                resultSet.getString("nama"),
                resultSet.getString("no_hp"),
                resultSet.getString("alamat")
        );
        TransaksiLaundry transaksi = new TransaksiLaundry();
        transaksi.setIdTransaksi(resultSet.getInt("id_transaksi"));
        transaksi.setPelanggan(pelanggan);
        transaksi.setTanggalMasuk(resultSet.getDate("tanggal_masuk").toLocalDate());
        transaksi.setTanggalSelesaiEst(resultSet.getDate("tanggal_selesai_est").toLocalDate());
        transaksi.setStatus(resultSet.getString("status_transaksi"));
        transaksi.setTotal(resultSet.getBigDecimal("total"));

        Pembayaran pembayaran = new Pembayaran();
        pembayaran.setIdPembayaran(resultSet.getInt("id_pembayaran"));
        pembayaran.setTransaksi(transaksi);
        pembayaran.setTanggalBayar(resultSet.getDate("tanggal_bayar").toLocalDate());
        pembayaran.setMetode(resultSet.getString("metode"));
        pembayaran.setJumlahBayar(resultSet.getBigDecimal("jumlah_bayar"));
        pembayaran.setStatus(resultSet.getString("status_bayar"));
        return pembayaran;
    }
}
