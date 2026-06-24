package com.laundryku.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Model untuk tempat laundry (agregasi layanan)
public class Laundry {
    private String namaLaundry;

    // Agregasi: layanan dapat tetap ada walaupun objek Laundry tidak digunakan
    private final List<LayananLaundry> daftarLayanan = new ArrayList<>();

    public Laundry(String namaLaundry) {
        this.namaLaundry = namaLaundry;
    }

    public void tambahLayanan(LayananLaundry layanan) {
        if (layanan != null) {
            daftarLayanan.add(layanan);
        }
    }

    public String getNamaLaundry() { return namaLaundry; }
    public void setNamaLaundry(String namaLaundry) { this.namaLaundry = namaLaundry; }
    public List<LayananLaundry> getDaftarLayanan() {
        return Collections.unmodifiableList(daftarLayanan);
    }
}
