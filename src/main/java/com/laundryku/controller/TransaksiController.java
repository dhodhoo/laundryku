package com.laundryku.controller;

import com.laundryku.dao.TransaksiDAO;
import com.laundryku.model.DetailLaundry;
import com.laundryku.model.LayananLaundry;
import com.laundryku.model.Pelanggan;
import com.laundryku.model.TransaksiLaundry;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

// Controller untuk transaksi laundry
public class TransaksiController {
    private final TransaksiDAO transaksiDAO = new TransaksiDAO();

    // Ambil semua transaksi
    public List<TransaksiLaundry> getAllTransaksi() throws SQLException {
        return transaksiDAO.findAll();
    }

    // Ambil detail transaksi + daftar laundry berdasarkan ID
    public TransaksiLaundry getTransaksiDetail(int idTransaksi) throws SQLException {
        return transaksiDAO.findByIdWithDetails(idTransaksi);
    }

    // Tambah transaksi baru (hitung estimasi selesai otomatis)
    public void tambahTransaksi(Pelanggan pelanggan, LayananLaundry layanan, String jenisPakaian,
                                int jumlahPakaian, BigDecimal beratKg) throws SQLException {
        TransaksiLaundry transaksi = new TransaksiLaundry(
                pelanggan,
                LocalDate.now(),
                LocalDate.now().plusDays(layanan.getEstimasiHari())
        );
        DetailLaundry detail = new DetailLaundry(layanan, jenisPakaian, jumlahPakaian, beratKg);
        transaksi.tambahDetail(detail);
        transaksiDAO.save(transaksi);
    }

    // Ubah status transaksi (DIPROSES/DICUCI/SELESAI/DIAMBIL)
    public void ubahStatus(int idTransaksi, String status) throws SQLException {
        transaksiDAO.updateStatus(idTransaksi, status);
    }

    // Hapus transaksi (detail & pembayaran terkait ikut terhapus di DB via CASCADE)
    public void hapusTransaksi(int idTransaksi) throws SQLException {
        transaksiDAO.delete(idTransaksi);
    }
}
