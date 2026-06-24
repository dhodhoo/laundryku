package com.laundryku.controller;

import com.laundryku.dao.PelangganDAO;
import com.laundryku.model.Pelanggan;
import java.sql.SQLException;
import java.util.List;

// Controller untuk CRUD pelanggan
public class PelangganController {
    private final PelangganDAO pelangganDAO = new PelangganDAO();

    // Ambil semua data pelanggan
    public List<Pelanggan> getAllPelanggan() throws SQLException {
        return pelangganDAO.findAll();
    }

    // Tambah pelanggan baru
    public void tambahPelanggan(String nama, String noHp, String alamat) throws SQLException {
        pelangganDAO.save(new Pelanggan(nama, noHp, alamat));
    }

    // Ubah data pelanggan berdasarkan ID
    public void ubahPelanggan(int id, String nama, String noHp, String alamat) throws SQLException {
        pelangganDAO.update(new Pelanggan(id, nama, noHp, alamat));
    }

    // Hapus pelanggan berdasarkan ID
    public void hapusPelanggan(int id) throws SQLException {
        pelangganDAO.delete(id);
    }
}
