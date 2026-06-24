package com.laundryku.controller;

import com.laundryku.dao.LayananDAO;
import com.laundryku.model.LayananLaundry;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

// Controller untuk CRUD layanan laundry
public class LayananController {
    private final LayananDAO layananDAO = new LayananDAO();

    // Ambil semua data layanan
    public List<LayananLaundry> getAllLayanan() throws SQLException {
        return layananDAO.findAll();
    }

    // Tambah layanan baru
    public void tambahLayanan(String namaLayanan, BigDecimal hargaPerKg, int estimasiHari) throws SQLException {
        layananDAO.save(new LayananLaundry(namaLayanan, hargaPerKg, estimasiHari));
    }

    // Ubah data layanan berdasarkan ID
    public void ubahLayanan(int id, String namaLayanan, BigDecimal hargaPerKg, int estimasiHari) throws SQLException {
        layananDAO.update(new LayananLaundry(id, namaLayanan, hargaPerKg, estimasiHari));
    }

    // Hapus layanan berdasarkan ID
    public void hapusLayanan(int id) throws SQLException {
        layananDAO.delete(id);
    }
}
