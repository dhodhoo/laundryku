package com.laundryku.model;

import java.math.BigDecimal;

// Model untuk detail item dalam transaksi laundry
public class DetailLaundry {
    private int idDetail;
    private int idTransaksi;
    private LayananLaundry layanan;
    private String jenisPakaian;
    private int jumlahPakaian;
    private BigDecimal beratKg;
    private BigDecimal subtotal;

    public DetailLaundry() {
    }

    public DetailLaundry(LayananLaundry layanan, String jenisPakaian, int jumlahPakaian, BigDecimal beratKg) {
        this.layanan = layanan;
        this.jenisPakaian = jenisPakaian;
        this.jumlahPakaian = jumlahPakaian;
        this.beratKg = beratKg;
        hitungSubtotal();
    }

    // Hitung subtotal = harga_per_kg * berat_kg
    public void hitungSubtotal() {
        if (layanan != null && layanan.getHargaPerKg() != null && beratKg != null) {
            subtotal = layanan.getHargaPerKg().multiply(beratKg);
        } else {
            subtotal = BigDecimal.ZERO;
        }
    }

    public int getIdDetail() { return idDetail; }
    public void setIdDetail(int idDetail) { this.idDetail = idDetail; }
    public int getIdTransaksi() { return idTransaksi; }
    public void setIdTransaksi(int idTransaksi) { this.idTransaksi = idTransaksi; }
    public LayananLaundry getLayanan() { return layanan; }
    public void setLayanan(LayananLaundry layanan) { this.layanan = layanan; hitungSubtotal(); }
    public String getJenisPakaian() { return jenisPakaian; }
    public void setJenisPakaian(String jenisPakaian) { this.jenisPakaian = jenisPakaian; }
    public int getJumlahPakaian() { return jumlahPakaian; }
    public void setJumlahPakaian(int jumlahPakaian) { this.jumlahPakaian = jumlahPakaian; }
    public BigDecimal getBeratKg() { return beratKg; }
    public void setBeratKg(BigDecimal beratKg) { this.beratKg = beratKg; hitungSubtotal(); }
    public BigDecimal getSubtotal() { return subtotal; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }
}
