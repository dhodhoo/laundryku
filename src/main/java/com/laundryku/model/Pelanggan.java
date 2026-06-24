package com.laundryku.model;

// Model untuk data pelanggan
public class Pelanggan {
    private int idPelanggan;
    private String nama;
    private String noHp;
    private String alamat;

    public Pelanggan() {
    }

    // Constructor lengkap dengan ID (untuk update/delete)
    public Pelanggan(int idPelanggan, String nama, String noHp, String alamat) {
        this.idPelanggan = idPelanggan;
        this.nama = nama;
        this.noHp = noHp;
        this.alamat = alamat;
    }

    // Constructor tanpa ID (untuk insert baru)
    public Pelanggan(String nama, String noHp, String alamat) {
        this.nama = nama;
        this.noHp = noHp;
        this.alamat = alamat;
    }

    // Getter & Setter
    public int getIdPelanggan() { return idPelanggan; }
    public void setIdPelanggan(int idPelanggan) { this.idPelanggan = idPelanggan; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getNoHp() { return noHp; }
    public void setNoHp(String noHp) { this.noHp = noHp; }
    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }

    @Override
    public String toString() {
        return idPelanggan + " - " + nama;
    }
}
