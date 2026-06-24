package com.laundryku.dao;

import com.laundryku.config.DatabaseConnection;
import com.laundryku.model.DetailLaundry;
import com.laundryku.model.LayananLaundry;
import com.laundryku.model.Pelanggan;
import com.laundryku.model.TransaksiLaundry;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// DAO untuk akses data transaksi laundry di database
public class TransaksiDAO {

    // Ambil semua transaksi tanpa detail (efisien untuk tabel)
    public List<TransaksiLaundry> findAll() throws SQLException {
        List<TransaksiLaundry> list = new ArrayList<>();
        String sql = """
                SELECT t.id_transaksi, t.tanggal_masuk, t.tanggal_selesai_est, t.status, t.total,
                       p.id_pelanggan, p.nama, p.no_hp, p.alamat
                FROM transaksi_laundry t
                JOIN pelanggan p ON p.id_pelanggan = t.id_pelanggan
                ORDER BY t.id_transaksi DESC
                """;
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                list.add(mapTransaksiRingkas(resultSet));
            }
        }
        return list;
    }

    // Cari transaksi + detail laundry berdasarkan ID
    public TransaksiLaundry findByIdWithDetails(int id) throws SQLException {
        String sqlTransaksi = """
                SELECT t.id_transaksi, t.tanggal_masuk, t.tanggal_selesai_est, t.status, t.total,
                       p.id_pelanggan, p.nama, p.no_hp, p.alamat
                FROM transaksi_laundry t
                JOIN pelanggan p ON p.id_pelanggan = t.id_pelanggan
                WHERE t.id_transaksi = ?
                """;
        String sqlDetail = """
                SELECT d.id_detail, d.id_transaksi, d.jenis_pakaian, d.jumlah_pakaian, d.berat_kg, d.subtotal,
                       l.id_layanan, l.nama_layanan, l.harga_per_kg, l.estimasi_hari
                FROM detail_laundry d
                JOIN layanan_laundry l ON l.id_layanan = d.id_layanan
                WHERE d.id_transaksi = ?
                """;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement transaksiStatement = connection.prepareStatement(sqlTransaksi)) {
            transaksiStatement.setInt(1, id);
            try (ResultSet resultSet = transaksiStatement.executeQuery()) {
                if (!resultSet.next()) return null;
                TransaksiLaundry transaksi = mapTransaksiRingkas(resultSet);
                // Ambil detail-detail transaksi
                try (PreparedStatement detailStatement = connection.prepareStatement(sqlDetail)) {
                    detailStatement.setInt(1, id);
                    try (ResultSet detailResult = detailStatement.executeQuery()) {
                        while (detailResult.next()) {
                            LayananLaundry layanan = new LayananLaundry(
                                    detailResult.getInt("id_layanan"),
                                    detailResult.getString("nama_layanan"),
                                    detailResult.getBigDecimal("harga_per_kg"),
                                    detailResult.getInt("estimasi_hari")
                            );
                            DetailLaundry detail = new DetailLaundry();
                            detail.setIdDetail(detailResult.getInt("id_detail"));
                            detail.setIdTransaksi(detailResult.getInt("id_transaksi"));
                            detail.setLayanan(layanan);
                            detail.setJenisPakaian(detailResult.getString("jenis_pakaian"));
                            detail.setJumlahPakaian(detailResult.getInt("jumlah_pakaian"));
                            detail.setBeratKg(detailResult.getBigDecimal("berat_kg"));
                            detail.setSubtotal(detailResult.getBigDecimal("subtotal"));
                            transaksi.tambahDetail(detail);
                        }
                    }
                }
                transaksi.setTotal(resultSet.getBigDecimal("total"));
                return transaksi;
            }
        }
    }

    // Simpan transaksi + detail (dalam satu transaksi database)
    public void save(TransaksiLaundry transaksi) throws SQLException {
        String sqlTransaksi = "INSERT INTO transaksi_laundry (id_pelanggan, tanggal_masuk, tanggal_selesai_est, status, total) VALUES (?, ?, ?, ?, ?)";
        String sqlDetail = "INSERT INTO detail_laundry (id_transaksi, id_layanan, jenis_pakaian, jumlah_pakaian, berat_kg, subtotal) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection()) {
            connection.setAutoCommit(false); // mulai transaksi database
            try (PreparedStatement transaksiStatement = connection.prepareStatement(sqlTransaksi, Statement.RETURN_GENERATED_KEYS)) {
                transaksi.hitungTotal();
                transaksiStatement.setInt(1, transaksi.getPelanggan().getIdPelanggan());
                transaksiStatement.setDate(2, Date.valueOf(transaksi.getTanggalMasuk()));
                transaksiStatement.setDate(3, Date.valueOf(transaksi.getTanggalSelesaiEst()));
                transaksiStatement.setString(4, transaksi.getStatus());
                transaksiStatement.setBigDecimal(5, transaksi.getTotal());
                transaksiStatement.executeUpdate();

                // Ambil ID transaksi yang baru saja dibuat
                try (ResultSet generatedKeys = transaksiStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        transaksi.setIdTransaksi(generatedKeys.getInt(1));
                    }
                }

                // Simpan detail-detail laundry
                try (PreparedStatement detailStatement = connection.prepareStatement(sqlDetail)) {
                    for (DetailLaundry detail : transaksi.getDaftarDetail()) {
                        detailStatement.setInt(1, transaksi.getIdTransaksi());
                        detailStatement.setInt(2, detail.getLayanan().getIdLayanan());
                        detailStatement.setString(3, detail.getJenisPakaian());
                        detailStatement.setInt(4, detail.getJumlahPakaian());
                        detailStatement.setBigDecimal(5, detail.getBeratKg());
                        detailStatement.setBigDecimal(6, detail.getSubtotal());
                        detailStatement.addBatch();
                    }
                    detailStatement.executeBatch();
                }
                connection.commit(); // sukses, simpan perubahan
            } catch (SQLException e) {
                connection.rollback(); // gagal, batalkan semua
                throw e;
            } finally {
                connection.setAutoCommit(true);
            }
        }
    }

    // Update status transaksi
    public void updateStatus(int idTransaksi, String status) throws SQLException {
        String sql = "UPDATE transaksi_laundry SET status = ? WHERE id_transaksi = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, status);
            statement.setInt(2, idTransaksi);
            statement.executeUpdate();
        }
    }

    // Hapus transaksi (detail terkait ikut terhapus via CASCADE di DB)
    public void delete(int idTransaksi) throws SQLException {
        String sql = "DELETE FROM transaksi_laundry WHERE id_transaksi = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idTransaksi);
            statement.executeUpdate();
        }
    }

    // Mapping baris hasil query ke objek TransaksiLaundry (tanpa detail)
    private TransaksiLaundry mapTransaksiRingkas(ResultSet resultSet) throws SQLException {
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
        transaksi.setStatus(resultSet.getString("status"));
        transaksi.setTotal(resultSet.getBigDecimal("total"));
        return transaksi;
    }
}
