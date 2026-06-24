package com.laundryku.dao;

import com.laundryku.config.DatabaseConnection;
import com.laundryku.model.Pelanggan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// DAO untuk akses data pelanggan di database
public class PelangganDAO {

    // Ambil semua pelanggan (dari yang terbaru)
    public List<Pelanggan> findAll() throws SQLException {
        List<Pelanggan> list = new ArrayList<>();
        String sql = "SELECT id_pelanggan, nama, no_hp, alamat FROM pelanggan ORDER BY id_pelanggan DESC";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                list.add(mapResultSet(resultSet));
            }
        }
        return list;
    }

    // Cari pelanggan berdasarkan ID
    public Pelanggan findById(int id) throws SQLException {
        String sql = "SELECT id_pelanggan, nama, no_hp, alamat FROM pelanggan WHERE id_pelanggan = ?";
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

    // Simpan pelanggan baru
    public void save(Pelanggan pelanggan) throws SQLException {
        String sql = "INSERT INTO pelanggan (nama, no_hp, alamat) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, pelanggan.getNama());
            statement.setString(2, pelanggan.getNoHp());
            statement.setString(3, pelanggan.getAlamat());
            statement.executeUpdate();
        }
    }

    // Update data pelanggan
    public void update(Pelanggan pelanggan) throws SQLException {
        String sql = "UPDATE pelanggan SET nama = ?, no_hp = ?, alamat = ? WHERE id_pelanggan = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, pelanggan.getNama());
            statement.setString(2, pelanggan.getNoHp());
            statement.setString(3, pelanggan.getAlamat());
            statement.setInt(4, pelanggan.getIdPelanggan());
            statement.executeUpdate();
        }
    }

    // Hapus pelanggan berdasarkan ID
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM pelanggan WHERE id_pelanggan = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    // Mapping hasil query ke objek Pelanggan
    private Pelanggan mapResultSet(ResultSet resultSet) throws SQLException {
        return new Pelanggan(
                resultSet.getInt("id_pelanggan"),
                resultSet.getString("nama"),
                resultSet.getString("no_hp"),
                resultSet.getString("alamat")
        );
    }
}
