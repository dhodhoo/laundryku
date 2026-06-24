package com.laundryku.view;

import com.laundryku.controller.LayananController;
import com.laundryku.model.LayananLaundry;
import com.laundryku.util.CurrencyUtil;
import com.laundryku.util.ValidationUtil;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

/**
 * Panel untuk mengelola data Layanan Laundry (CRUD).
 * - Menampilkan daftar layanan dalam tabel
 * - Form input untuk nama, harga per kg, estimasi hari
 * - Harga ditampilkan dalam format Rupiah
 */
public class LayananView extends javax.swing.JPanel {

    // Controller untuk komunikasi dengan database
    private final LayananController controller = new LayananController();

    // Nama kolom tabel
    private static final String[] TABLE_COLUMNS = {"ID", "Nama Layanan", "Harga/Kg", "Estimasi Hari"};

    // Model tabel -- sel tidak bisa diedit langsung
    private final DefaultTableModel tableModel = new DefaultTableModel(TABLE_COLUMNS, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    // Constructor: init GUI, set model tabel, konfigurasi, muat data.
    public LayananView() {
        initComponents();
        layananTable.setModel(tableModel);
        configureTable();
        loadData();
        wireListeners();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        namaLayananLabel = new javax.swing.JLabel();
        namaLayananField = new javax.swing.JTextField();
        hargaPerKgLabel = new javax.swing.JLabel();
        hargaPerKgField = new javax.swing.JTextField();
        estimasiLabel = new javax.swing.JLabel();
        estimasiField = new javax.swing.JTextField();
        tambahButton = new javax.swing.JButton();
        ubahButton = new javax.swing.JButton();
        hapusButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        layananTable = new javax.swing.JTable();
        refreshButton = new javax.swing.JButton();

        namaLayananLabel.setText("Nama Layanan: ");

        namaLayananField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaLayananFieldActionPerformed(evt);
            }
        });

        hargaPerKgLabel.setText("Harga per Kg: ");

        hargaPerKgField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hargaPerKgFieldActionPerformed(evt);
            }
        });

        estimasiLabel.setText("Estimasi Hari: ");

        estimasiField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estimasiFieldActionPerformed(evt);
            }
        });

        tambahButton.setText("Tambah");

        ubahButton.setText("Ubah");

        hapusButton.setText("Hapus");

        resetButton.setText("Reset");

        layananTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nama Layanan", "Harga per Kg", "Estimasi Hari"
            }
        ));
        jScrollPane1.setViewportView(layananTable);

        refreshButton.setText("Refresh");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(namaLayananLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(namaLayananField))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(hargaPerKgLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hargaPerKgField))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(estimasiLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(estimasiField))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tambahButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ubahButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hapusButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resetButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refreshButton)
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(namaLayananField)
                    .addComponent(namaLayananLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hargaPerKgField)
                    .addComponent(hargaPerKgLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(estimasiField)
                    .addComponent(estimasiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahButton)
                    .addComponent(ubahButton)
                    .addComponent(hapusButton)
                    .addComponent(resetButton)
                    .addComponent(refreshButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void namaLayananFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaLayananFieldActionPerformed
    }//GEN-LAST:event_namaLayananFieldActionPerformed

    private void hargaPerKgFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hargaPerKgFieldActionPerformed
    }//GEN-LAST:event_hargaPerKgFieldActionPerformed

    private void estimasiFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estimasiFieldActionPerformed
    }//GEN-LAST:event_estimasiFieldActionPerformed

    // Ikat event listener ke tombol.
    private void wireListeners() {
        tambahButton.addActionListener(e -> tambah());
        ubahButton.addActionListener(e -> ubah());
        hapusButton.addActionListener(e -> hapus());
        resetButton.addActionListener(e -> resetForm());
        refreshButton.addActionListener(e -> loadData());
    }

    // Saat baris tabel dipilih, isi form.
    private void configureTable() {
        layananTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        layananTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && layananTable.getSelectedRow() >= 0) {
                int row = layananTable.getSelectedRow();
                namaLayananField.setText(tableModel.getValueAt(row, 1).toString());
                // Hapus format Rp dari harga sebelum diisi ke form
                String harga = tableModel.getValueAt(row, 2).toString().replace("Rp", "").replace(".", "").replace(",00", "").trim();
                hargaPerKgField.setText(harga);
                estimasiField.setText(tableModel.getValueAt(row, 3).toString());
            }
        });
    }

    // Muat ulang data layanan dari database ke tabel.
    private void loadData() {
        try {
            tableModel.setRowCount(0);
            List<LayananLaundry> data = controller.getAllLayanan();
            for (LayananLaundry layanan : data) {
                tableModel.addRow(new Object[]{
                        layanan.getIdLayanan(), layanan.getNamaLayanan(), CurrencyUtil.rupiah(layanan.getHargaPerKg()), layanan.getEstimasiHari()
                });
            }
        } catch (SQLException e) {
            showError(e);
        }
    }

    // Ambil ID dari baris tabel yang dipilih.
    private int getSelectedId() {
        int row = layananTable.getSelectedRow();
        if (row >= 0) {
            Object val = tableModel.getValueAt(row, 0);
            if (val != null) return Integer.parseInt(val.toString());
        }
        return -1;
    }

    // Tambah layanan baru.
    private void tambah() {
        try {
            validateInput();
            BigDecimal harga = ValidationUtil.parseDecimal(hargaPerKgField.getText(), "Harga per Kg");
            int estimasi = ValidationUtil.parseInteger(estimasiField.getText(), "Estimasi Hari");
            controller.tambahLayanan(namaLayananField.getText(), harga, estimasi);
            resetForm();
            loadData();
            JOptionPane.showMessageDialog(this, "Layanan berhasil ditambahkan.");
        } catch (Exception e) {
            showError(e);
        }
    }

    // Ubah data layanan yang dipilih.
    private void ubah() {
        try {
            int id = getSelectedId();
            if (id < 0) throw new IllegalArgumentException("Pilih data layanan terlebih dahulu.");
            validateInput();
            BigDecimal harga = ValidationUtil.parseDecimal(hargaPerKgField.getText(), "Harga per Kg");
            int estimasi = ValidationUtil.parseInteger(estimasiField.getText(), "Estimasi Hari");
            controller.ubahLayanan(id, namaLayananField.getText(), harga, estimasi);
            resetForm();
            loadData();
            JOptionPane.showMessageDialog(this, "Layanan berhasil diubah.");
        } catch (Exception e) {
            showError(e);
        }
    }

    // Hapus layanan setelah konfirmasi.
    private void hapus() {
        try {
            int id = getSelectedId();
            if (id < 0) throw new IllegalArgumentException("Pilih data layanan terlebih dahulu.");
            int confirm = JOptionPane.showConfirmDialog(this, "Hapus layanan terpilih?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                controller.hapusLayanan(id);
                resetForm();
                loadData();
            }
        } catch (Exception e) {
            showError(e);
        }
    }

    // Validasi field wajib.
    private void validateInput() {
        if (ValidationUtil.isBlank(namaLayananField.getText())) throw new IllegalArgumentException("Nama layanan wajib diisi.");
        if (ValidationUtil.isBlank(hargaPerKgField.getText())) throw new IllegalArgumentException("Harga per Kg wajib diisi.");
        if (ValidationUtil.isBlank(estimasiField.getText())) throw new IllegalArgumentException("Estimasi hari wajib diisi.");
    }

    // Kosongkan form.
    private void resetForm() {
        namaLayananField.setText("");
        hargaPerKgField.setText("");
        estimasiField.setText("");
        layananTable.clearSelection();
    }

    private void showError(Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField estimasiField;
    private javax.swing.JLabel estimasiLabel;
    private javax.swing.JButton hapusButton;
    private javax.swing.JTextField hargaPerKgField;
    private javax.swing.JLabel hargaPerKgLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable layananTable;
    private javax.swing.JTextField namaLayananField;
    private javax.swing.JLabel namaLayananLabel;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton tambahButton;
    private javax.swing.JButton ubahButton;
    // End of variables declaration//GEN-END:variables
}

