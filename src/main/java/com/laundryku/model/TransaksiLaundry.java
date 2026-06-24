package com.laundryku.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Model untuk data transaksi laundry
public class TransaksiLaundry {
    private int idTransaksi;
    private Pelanggan pelanggan;
    private LocalDate tanggalMasuk;
    private LocalDate tanggalSelesaiEst;
    private String status;
    private BigDecimal total;

    // Komposisi: DetailLaundry hidup sebagai bagian dari TransaksiLaundry
    private final List<DetailLaundry> daftarDetail = new ArrayList<>();

    public TransaksiLaundry() {
        this.status = "DIPROSES";
        this.total = BigDecimal.ZERO;
    }

    public TransaksiLaundry(Pelanggan pelanggan, LocalDate tanggalMasuk, LocalDate tanggalSelesaiEst) {
        this.pelanggan = pelanggan;
        this.tanggalMasuk = tanggalMasuk;
        this.tanggalSelesaiEst = tanggalSelesaiEst;
        this.status = "DIPROSES";
        this.total = BigDecimal.ZERO;
    }

    public void tambahDetail(DetailLaundry detail) {
        if (detail != null) {
            daftarDetail.add(detail);
            hitungTotal();
        }
    }

    // Hitung total dari semua subtotal detail
    public void hitungTotal() {
        total = daftarDetail.stream()
                .map(DetailLaundry::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<DetailLaundry> getDaftarDetail() {
        return Collections.unmodifiableList(daftarDetail);
    }

    public int getIdTransaksi() { return idTransaksi; }
    public void setIdTransaksi(int idTransaksi) { this.idTransaksi = idTransaksi; }
    public Pelanggan getPelanggan() { return pelanggan; }
    public void setPelanggan(Pelanggan pelanggan) { this.pelanggan = pelanggan; }
    public LocalDate getTanggalMasuk() { return tanggalMasuk; }
    public void setTanggalMasuk(LocalDate tanggalMasuk) { this.tanggalMasuk = tanggalMasuk; }
    public LocalDate getTanggalSelesaiEst() { return tanggalSelesaiEst; }
    public void setTanggalSelesaiEst(LocalDate tanggalSelesaiEst) { this.tanggalSelesaiEst = tanggalSelesaiEst; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }

    @Override
    public String toString() {
        String nama = pelanggan == null ? "Pelanggan" : pelanggan.getNama();
        return "TRX-" + idTransaksi + " - " + nama + " - Rp" + total;
    }
}
