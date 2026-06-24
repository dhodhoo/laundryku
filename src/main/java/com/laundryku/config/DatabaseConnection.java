package com.laundryku.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Pengaturan koneksi ke database MySQL
public final class DatabaseConnection {
    // Alamat database MySQL di localhost
    private static final String URL = "jdbc:mysql://localhost:3306/laundryku_db?useSSL=false&serverTimezone=Asia/Jakarta";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Constructor private agar tidak bisa di-instansiasi
    private DatabaseConnection() {
    }

    // Mendapatkan koneksi ke database
    public static Connection getConnection() throws SQLException {
        try {
            // Load driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL Connector/J belum tersedia. Pastikan dependency Maven sudah terunduh.", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
