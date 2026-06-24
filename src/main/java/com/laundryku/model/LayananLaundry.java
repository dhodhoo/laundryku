package com.laundryku.model;

import java.math.BigDecimal;

// Model untuk data layanan laundry
public class LayananLaundry {
    private int idLayanan;
    private String namaLayanan;
    private BigDecimal hargaPerKg;
    private int estimasiHari;

    public LayananLaundry() {
    }

    public LayananLaundry(int idLayanan, String namaLayanan, BigDecimal hargaPerKg, int estimasiHari) {
        this.idLayanan = idLayanan;
        this.namaLayanan = namaLayanan;
        this.hargaPerKg = hargaPerKg;
        this.estimasiHari = estimasiHari;
    }

    // Constructor tanpa ID (untuk insert baru)
    public LayananLaundry(String namaLayanan, BigDecimal hargaPerKg, int estimasiHari) {
        this.namaLayanan = namaLayanan;
        this.hargaPerKg = hargaPerKg;
        this.estimasiHari = estimasiHari;
    }

    public int getIdLayanan() { return idLayanan; }
    public void setIdLayanan(int idLayanan) { this.idLayanan = idLayanan; }
    public String getNamaLayanan() { return namaLayanan; }
    public void setNamaLayanan(String namaLayanan) { this.namaLayanan = namaLayanan; }
    public BigDecimal getHargaPerKg() { return hargaPerKg; }
    public void setHargaPerKg(BigDecimal hargaPerKg) { this.hargaPerKg = hargaPerKg; }
    public int getEstimasiHari() { return estimasiHari; }
    public void setEstimasiHari(int estimasiHari) { this.estimasiHari = estimasiHari; }

    @Override
    public String toString() {
        return idLayanan + " - " + namaLayanan;
    }
}
