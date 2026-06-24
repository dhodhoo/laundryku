package com.laundryku.view;

import com.laundryku.controller.PembayaranController;
import com.laundryku.controller.TransaksiController;
import com.laundryku.model.Pembayaran;
import com.laundryku.model.TransaksiLaundry;
import com.laundryku.util.CurrencyUtil;
import com.laundryku.util.ValidationUtil;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class PembayaranView extends javax.swing.JPanel {

    private final PembayaranController pembayaranController = new PembayaranController();
    private final TransaksiController transaksiController = new TransaksiController();

    private final DefaultTableModel tableModel = new DefaultTableModel(
            new Object[]{"ID Bayar", "ID Transaksi", "Pelanggan", "Tanggal", "Metode", "Jumlah", "Status"}, 0
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public PembayaranView() {
        initComponents();
        jumlahBayarField.setEditable(true);
        metodeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"TUNAI", "TRANSFER", "QRIS", "DEBIT"}));
        pembayaranTable.setModel(tableModel);
        configureTable();
        reloadTransaksiCombo();
        loadData();
        wireListeners();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        transaksiLabel = new javax.swing.JLabel();
        tanggalBayarLabel = new javax.swing.JLabel();
        tanggalBayarField = new javax.swing.JTextField();
        tambahButton = new javax.swing.JButton();
        ubahButton = new javax.swing.JButton();
        hapusButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pembayaranTable = new javax.swing.JTable();
        jumlahBayarLabel = new javax.swing.JLabel();
        jumlahBayarField = new javax.swing.JTextField();
        metodeLabel = new javax.swing.JLabel();
        transaksiComboBox = new javax.swing.JComboBox<>();
        metodeComboBox = new javax.swing.JComboBox<>();
        refreshButton = new javax.swing.JButton();

        transaksiLabel.setText("Transaksi: ");

        tanggalBayarLabel.setText("Tanggal Bayar: ");

        tanggalBayarField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanggalBayarFieldActionPerformed(evt);
            }
        });

        tambahButton.setText("Tambah");

        ubahButton.setText("Ubah");

        hapusButton.setText("Hapus");

        resetButton.setText("Reset");

        pembayaranTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Bayar", "ID Transaksi", "Pelanggan", "Tanggal", "Metode", "Jumlah", "Status"
            }
        ));
        jScrollPane1.setViewportView(pembayaranTable);

        jumlahBayarLabel.setText("Jumlah Bayar: ");

        jumlahBayarField.setEditable(false);
        jumlahBayarField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahBayarFieldActionPerformed(evt);
            }
        });

        metodeLabel.setText("Metode: ");

        transaksiComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        metodeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        refreshButton.setText("Refresh");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tanggalBayarLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tanggalBayarField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jumlahBayarLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jumlahBayarField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(transaksiLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(transaksiComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(metodeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(metodeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transaksiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(transaksiComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tanggalBayarField)
                    .addComponent(tanggalBayarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(metodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(metodeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jumlahBayarField)
                    .addComponent(jumlahBayarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void tanggalBayarFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanggalBayarFieldActionPerformed
    }//GEN-LAST:event_tanggalBayarFieldActionPerformed

    private void jumlahBayarFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahBayarFieldActionPerformed
    }//GEN-LAST:event_jumlahBayarFieldActionPerformed

    // Ikat event listener ke tombol.
    private void wireListeners() {
        tambahButton.addActionListener(e -> tambah());
        ubahButton.addActionListener(e -> ubah());
        hapusButton.addActionListener(e -> hapus());
        resetButton.addActionListener(e -> resetForm());
        refreshButton.addActionListener(e -> { reloadTransaksiCombo(); loadData(); });
    }

    // Saat baris tabel dipilih, isi form dengan data pembayaran.
    private void configureTable() {
        pembayaranTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        pembayaranTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && pembayaranTable.getSelectedRow() >= 0) {
                int row = pembayaranTable.getSelectedRow();
                selectTransaksiById(Integer.parseInt(tableModel.getValueAt(row, 1).toString()));
                tanggalBayarField.setText(tableModel.getValueAt(row, 3).toString());
                metodeComboBox.setSelectedItem(tableModel.getValueAt(row, 4).toString());
                // Hapus format Rp sebelum diisi ke form
                String jumlah = tableModel.getValueAt(row, 5).toString().replace("Rp", "").replace(".", "").replace(",00", "").trim();
                jumlahBayarField.setText(jumlah);
            }
        });
    }

    // Muat ulang daftar transaksi ke combo box.
    private void reloadTransaksiCombo() {
        try {
            transaksiComboBox.removeAllItems();
            for (TransaksiLaundry transaksi : transaksiController.getAllTransaksi()) {
                transaksiComboBox.addItem(transaksi);
            }
        } catch (SQLException e) {
            showError(e);
        }
    }

    // Muat ulang data pembayaran dari database ke tabel.
    private void loadData() {
        try {
            tableModel.setRowCount(0);
            List<Pembayaran> data = pembayaranController.getAllPembayaran();
            for (Pembayaran pembayaran : data) {
                tableModel.addRow(new Object[]{
                        pembayaran.getIdPembayaran(),
                        pembayaran.getTransaksi().getIdTransaksi(),
                        pembayaran.getTransaksi().getPelanggan().getNama(),
                        pembayaran.getTanggalBayar(),
                        pembayaran.getMetode(),
                        CurrencyUtil.rupiah(pembayaran.getJumlahBayar()),
                        pembayaran.getStatus()
                });
            }
        } catch (SQLException e) {
            showError(e);
        }
    }

    // Ambil ID dari baris yang dipilih di tabel.
    private int getSelectedId() {
        int row = pembayaranTable.getSelectedRow();
        if (row >= 0) {
            Object val = tableModel.getValueAt(row, 0);
            if (val != null) return Integer.parseInt(val.toString());
        }
        return -1;
    }

    // Tambah pembayaran baru.
    private void tambah() {
        try {
            validateInput();
            TransaksiLaundry transaksi = (TransaksiLaundry) transaksiComboBox.getSelectedItem();
            LocalDate tanggal = LocalDate.parse(tanggalBayarField.getText().trim());
            BigDecimal jumlah = ValidationUtil.parseDecimal(jumlahBayarField.getText(), "Jumlah Bayar");
            pembayaranController.tambahPembayaran(transaksi, tanggal, metodeComboBox.getSelectedItem().toString(), jumlah);
            resetForm();
            loadData();
            JOptionPane.showMessageDialog(this, "Pembayaran berhasil ditambahkan.");
        } catch (Exception e) {
            showError(e);
        }
    }

    // Ubah data pembayaran yang dipilih.
    private void ubah() {
        try {
            int id = getSelectedId();
            if (id < 0) throw new IllegalArgumentException("Pilih pembayaran terlebih dahulu.");
            validateInput();
            TransaksiLaundry transaksi = (TransaksiLaundry) transaksiComboBox.getSelectedItem();
            LocalDate tanggal = LocalDate.parse(tanggalBayarField.getText().trim());
            BigDecimal jumlah = ValidationUtil.parseDecimal(jumlahBayarField.getText(), "Jumlah Bayar");
            pembayaranController.ubahPembayaran(id, transaksi, tanggal, metodeComboBox.getSelectedItem().toString(), jumlah);
            resetForm();
            loadData();
            JOptionPane.showMessageDialog(this, "Pembayaran berhasil diubah.");
        } catch (Exception e) {
            showError(e);
        }
    }

    // Hapus pembayaran setelah konfirmasi.
    private void hapus() {
        try {
            int id = getSelectedId();
            if (id < 0) throw new IllegalArgumentException("Pilih pembayaran terlebih dahulu.");
            int confirm = JOptionPane.showConfirmDialog(this, "Hapus pembayaran terpilih?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                pembayaranController.hapusPembayaran(id);
                resetForm();
                loadData();
            }
        } catch (Exception e) {
            showError(e);
        }
    }

    // Validasi field wajib.
    private void validateInput() {
        if (transaksiComboBox.getSelectedItem() == null) throw new IllegalArgumentException("Belum ada transaksi. Tambahkan transaksi terlebih dahulu.");
        if (ValidationUtil.isBlank(tanggalBayarField.getText())) throw new IllegalArgumentException("Tanggal bayar wajib diisi dengan format yyyy-MM-dd.");
        if (ValidationUtil.isBlank(jumlahBayarField.getText())) throw new IllegalArgumentException("Jumlah bayar wajib diisi.");
    }

    // Cari & pilih transaksi di combo berdasarkan ID.
    private void selectTransaksiById(int idTransaksi) {
        for (int i = 0; i < transaksiComboBox.getItemCount(); i++) {
            TransaksiLaundry transaksi = (TransaksiLaundry) transaksiComboBox.getItemAt(i);
            if (transaksi.getIdTransaksi() == idTransaksi) {
                transaksiComboBox.setSelectedIndex(i);
                return;
            }
        }
    }

    // Kosongkan form.
    private void resetForm() {
        tanggalBayarField.setText(LocalDate.now().toString());
        jumlahBayarField.setText("");
        metodeComboBox.setSelectedIndex(0);
        pembayaranTable.clearSelection();
    }

    // Tampilkan error dialog.
    private void showError(Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton hapusButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jumlahBayarField;
    private javax.swing.JLabel jumlahBayarLabel;
    private javax.swing.JComboBox metodeComboBox;
    private javax.swing.JLabel metodeLabel;
    private javax.swing.JTable pembayaranTable;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton tambahButton;
    private javax.swing.JTextField tanggalBayarField;
    private javax.swing.JLabel tanggalBayarLabel;
    private javax.swing.JComboBox transaksiComboBox;
    private javax.swing.JLabel transaksiLabel;
    private javax.swing.JButton ubahButton;
    // End of variables declaration//GEN-END:variables
}

