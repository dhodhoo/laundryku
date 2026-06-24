package com.laundryku.model;

import java.math.BigDecimal;
import java.time.LocalDate;

// Model untuk data pembayaran
public class Pembayaran {
    private int idPembayaran;
    private TransaksiLaundry transaksi;
    private LocalDate tanggalBayar;
    private String metode;
    private BigDecimal jumlahBayar;
    private String status;

    public Pembayaran() {
    }

    public Pembayaran(TransaksiLaundry transaksi, LocalDate tanggalBayar, String metode, BigDecimal jumlahBayar) {
        this.transaksi = transaksi;
        this.tanggalBayar = tanggalBayar;
        this.metode = metode;
        this.jumlahBayar = jumlahBayar;
        tentukanStatus();
    }

    // Tentukan status LUNAS / BELUM_LUNAS berdasarkan jumlah bayar
    public void tentukanStatus() {
        if (transaksi != null && transaksi.getTotal() != null && jumlahBayar != null
                && jumlahBayar.compareTo(transaksi.getTotal()) >= 0) {
            status = "LUNAS";
        } else {
            status = "BELUM_LUNAS";
        }
    }

    public int getIdPembayaran() { return idPembayaran; }
    public void setIdPembayaran(int idPembayaran) { this.idPembayaran = idPembayaran; }
    public TransaksiLaundry getTransaksi() { return transaksi; }
    public void setTransaksi(TransaksiLaundry transaksi) { this.transaksi = transaksi; tentukanStatus(); }
    public LocalDate getTanggalBayar() { return tanggalBayar; }
    public void setTanggalBayar(LocalDate tanggalBayar) { this.tanggalBayar = tanggalBayar; }
    public String getMetode() { return metode; }
    public void setMetode(String metode) { this.metode = metode; }
    public BigDecimal getJumlahBayar() { return jumlahBayar; }
    public void setJumlahBayar(BigDecimal jumlahBayar) { this.jumlahBayar = jumlahBayar; tentukanStatus(); }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
