package com.laundryku.dao;

import com.laundryku.config.DatabaseConnection;
import com.laundryku.model.LayananLaundry;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// DAO untuk akses data layanan laundry di database
public class LayananDAO {

    // Ambil semua layanan (dari yang terbaru)
    public List<LayananLaundry> findAll() throws SQLException {
        List<LayananLaundry> list = new ArrayList<>();
        String sql = "SELECT id_layanan, nama_layanan, harga_per_kg, estimasi_hari FROM layanan_laundry ORDER BY id_layanan DESC";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                list.add(mapResultSet(resultSet));
            }
        }
        return list;
    }

    // Cari layanan berdasarkan ID
    public LayananLaundry findById(int id) throws SQLException {
        String sql = "SELECT id_layanan, nama_layanan, harga_per_kg, estimasi_hari FROM layanan_laundry WHERE id_layanan = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSet(resultSet);
                }
            }
        }
        return null;
    }

    // Simpan layanan baru
    public void save(LayananLaundry layanan) throws SQLException {
        String sql = "INSERT INTO layanan_laundry (nama_layanan, harga_per_kg, estimasi_hari) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, layanan.getNamaLayanan());
            statement.setBigDecimal(2, layanan.getHargaPerKg());
            statement.setInt(3, layanan.getEstimasiHari());
            statement.executeUpdate();
        }
    }

    // Update data layanan
    public void update(LayananLaundry layanan) throws SQLException {
        String sql = "UPDATE layanan_laundry SET nama_layanan = ?, harga_per_kg = ?, estimasi_hari = ? WHERE id_layanan = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, layanan.getNamaLayanan());
            statement.setBigDecimal(2, layanan.getHargaPerKg());
            statement.setInt(3, layanan.getEstimasiHari());
            statement.setInt(4, layanan.getIdLayanan());
            statement.executeUpdate();
        }
    }

    // Hapus layanan berdasarkan ID
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM layanan_laundry WHERE id_layanan = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    // Mapping hasil query ke objek LayananLaundry
    private LayananLaundry mapResultSet(ResultSet resultSet) throws SQLException {
        return new LayananLaundry(
                resultSet.getInt("id_layanan"),
                resultSet.getString("nama_layanan"),
                resultSet.getBigDecimal("harga_per_kg"),
                resultSet.getInt("estimasi_hari")
        );
    }
}
