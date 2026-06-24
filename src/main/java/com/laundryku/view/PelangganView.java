package com.laundryku.view;

import com.laundryku.controller.PelangganController;
import com.laundryku.model.Pelanggan;
import com.laundryku.util.ValidationUtil;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

// Panel untuk mengelola data Pelanggan (CRUD).
// - Menampilkan daftar pelanggan dalam tabel
// - Form input untuk menambah/mengubah data
// - Menghapus dengan konfirmasi
public class PelangganView extends javax.swing.JPanel {

    private final PelangganController controller = new PelangganController();

    // Nama kolom tabel
    private static final String[] TABLE_COLUMNS = {"ID", "Nama", "No HP", "Alamat"};

    // Model tabel dengan sel tidak bisa diedit langsung
    private final DefaultTableModel tableModel = new DefaultTableModel(TABLE_COLUMNS, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    // Constructor: init GUI, set model tabel, konfigurasi listener, muat data.
    public PelangganView() {
        initComponents();
        pelangganTable.setModel(tableModel); // pakai model read-only kita
        configureTable();
        loadData();
        wireListeners();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        namaLabel = new javax.swing.JLabel();
        namaField = new javax.swing.JTextField();
        noHpLabel = new javax.swing.JLabel();
        noHpField = new javax.swing.JTextField();
        alamatLabel = new javax.swing.JLabel();
        alamatField = new javax.swing.JTextField();
        tambahButton = new javax.swing.JButton();
        ubahButton = new javax.swing.JButton();
        hapusButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pelangganTable = new javax.swing.JTable();
        refreshButton = new javax.swing.JButton();

        namaLabel.setText("Nama: ");

        namaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaFieldActionPerformed(evt);
            }
        });

        noHpLabel.setText("No Hp: ");

        noHpField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noHpFieldActionPerformed(evt);
            }
        });

        alamatLabel.setText("Alamat: ");

        alamatField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alamatFieldActionPerformed(evt);
            }
        });

        tambahButton.setText("Tambah");

        ubahButton.setText("Ubah");

        hapusButton.setText("Hapus");

        resetButton.setText("Reset");

        pelangganTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nama", "No Hp", "Alamat"
            }
        ));
        jScrollPane1.setViewportView(pelangganTable);

        refreshButton.setText("Refresh");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(namaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(namaField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(noHpLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(noHpField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(alamatLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(alamatField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tambahButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ubahButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hapusButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resetButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refreshButton)
                        .addGap(0, 4, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(namaField)
                    .addComponent(namaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(noHpField)
                    .addComponent(noHpLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(alamatField)
                    .addComponent(alamatLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahButton)
                    .addComponent(ubahButton)
                    .addComponent(hapusButton)
                    .addComponent(resetButton)
                    .addComponent(refreshButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void namaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaFieldActionPerformed
    }//GEN-LAST:event_namaFieldActionPerformed

    private void noHpFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noHpFieldActionPerformed
    }//GEN-LAST:event_noHpFieldActionPerformed

    private void alamatFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alamatFieldActionPerformed
    }//GEN-LAST:event_alamatFieldActionPerformed

    // Ikat event listener (lambda) ke tombol. Dipisah dari initComponents agar aman.
    private void wireListeners() {
        tambahButton.addActionListener(e -> tambah());
        ubahButton.addActionListener(e -> ubah());
        hapusButton.addActionListener(e -> hapus());
        resetButton.addActionListener(e -> resetForm());
        refreshButton.addActionListener(e -> loadData());
    }

    // Saat baris tabel dipilih, isi form dengan data dari baris tersebut.
    private void configureTable() {
        pelangganTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        pelangganTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && pelangganTable.getSelectedRow() >= 0) {
                int row = pelangganTable.getSelectedRow();
                namaField.setText(tableModel.getValueAt(row, 1).toString());
                noHpField.setText(tableModel.getValueAt(row, 2).toString());
                alamatField.setText(tableModel.getValueAt(row, 3).toString());
            }
        });
    }

    // Muat ulang data pelanggan dari database ke tabel.
    private void loadData() {
        try {
            tableModel.setRowCount(0); // kosongkan tabel dulu
            List<Pelanggan> data = controller.getAllPelanggan();
            for (Pelanggan pelanggan : data) {
                tableModel.addRow(new Object[]{
                        pelanggan.getIdPelanggan(), pelanggan.getNama(), pelanggan.getNoHp(), pelanggan.getAlamat()
                });
            }
        } catch (SQLException e) {
            showError(e);
        }
    }

    // Ambil ID dari baris yang dipilih di tabel.
    private int getSelectedId() {
        int row = pelangganTable.getSelectedRow();
        if (row >= 0) {
            Object val = tableModel.getValueAt(row, 0);
            if (val != null) return Integer.parseInt(val.toString());
        }
        return -1;
    }

    // Tambah pelanggan baru: validasi -> simpan -> reset -> refresh.
    private void tambah() {
        try {
            validateInput();
            controller.tambahPelanggan(namaField.getText(), noHpField.getText(), alamatField.getText());
            resetForm();
            loadData();
            JOptionPane.showMessageDialog(this, "Pelanggan berhasil ditambahkan.");
        } catch (Exception e) {
            showError(e);
        }
    }

    // Ubah data pelanggan yang dipilih.
    private void ubah() {
        try {
            int id = getSelectedId();
            if (id < 0) throw new IllegalArgumentException("Pilih data pelanggan terlebih dahulu.");
            validateInput();
            controller.ubahPelanggan(id, namaField.getText(), noHpField.getText(), alamatField.getText());
            resetForm();
            loadData();
            JOptionPane.showMessageDialog(this, "Pelanggan berhasil diubah.");
        } catch (Exception e) {
            showError(e);
        }
    }

    // Hapus pelanggan setelah konfirmasi Yes/No.
    private void hapus() {
        try {
            int id = getSelectedId();
            if (id < 0) throw new IllegalArgumentException("Pilih data pelanggan terlebih dahulu.");
            int confirm = JOptionPane.showConfirmDialog(this, "Hapus pelanggan terpilih?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                controller.hapusPelanggan(id);
                resetForm();
                loadData();
            }
        } catch (Exception e) {
            showError(e);
        }
    }

    // Validasi: pastikan semua field wajib terisi.
    private void validateInput() {
        if (ValidationUtil.isBlank(namaField.getText())) throw new IllegalArgumentException("Nama pelanggan wajib diisi.");
        if (ValidationUtil.isBlank(noHpField.getText())) throw new IllegalArgumentException("No HP wajib diisi.");
        if (ValidationUtil.isBlank(alamatField.getText())) throw new IllegalArgumentException("Alamat wajib diisi.");
    }

    // Kosongkan form dan hapus seleksi tabel.
    private void resetForm() {
        namaField.setText("");
        noHpField.setText("");
        alamatField.setText("");
        pelangganTable.clearSelection();
    }

    // Tampilkan pesan error dalam dialog.
    private void showError(Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamatField;
    private javax.swing.JLabel alamatLabel;
    private javax.swing.JButton hapusButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField namaField;
    private javax.swing.JLabel namaLabel;
    private javax.swing.JTextField noHpField;
    private javax.swing.JLabel noHpLabel;
    private javax.swing.JTable pelangganTable;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton tambahButton;
    private javax.swing.JButton ubahButton;
    // End of variables declaration//GEN-END:variables
}

