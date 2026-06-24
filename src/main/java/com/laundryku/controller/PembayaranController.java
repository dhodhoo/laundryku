package com.laundryku.controller;

import com.laundryku.dao.PembayaranDAO;
import com.laundryku.model.Pembayaran;
import com.laundryku.model.TransaksiLaundry;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

// Controller untuk pembayaran
public class PembayaranController {
    private final PembayaranDAO pembayaranDAO = new PembayaranDAO();

    // Ambil semua data pembayaran
    public List<Pembayaran> getAllPembayaran() throws SQLException {
        return pembayaranDAO.findAll();
    }

    // Tambah pembayaran baru
    public void tambahPembayaran(TransaksiLaundry transaksi, LocalDate tanggalBayar, String metode, BigDecimal jumlahBayar) throws SQLException {
        pembayaranDAO.save(new Pembayaran(transaksi, tanggalBayar, metode, jumlahBayar));
    }

    // Ubah data pembayaran berdasarkan ID
    public void ubahPembayaran(int idPembayaran, TransaksiLaundry transaksi, LocalDate tanggalBayar,
                               String metode, BigDecimal jumlahBayar) throws SQLException {
        Pembayaran pembayaran = new Pembayaran(transaksi, tanggalBayar, metode, jumlahBayar);
        pembayaran.setIdPembayaran(idPembayaran);
        pembayaranDAO.update(pembayaran);
    }

    // Hapus pembayaran berdasarkan ID
    public void hapusPembayaran(int idPembayaran) throws SQLException {
        pembayaranDAO.delete(idPembayaran);
    }
}
