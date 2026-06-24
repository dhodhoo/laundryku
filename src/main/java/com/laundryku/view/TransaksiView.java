package com.laundryku.view;

import com.laundryku.controller.LayananController;
import com.laundryku.controller.PelangganController;
import com.laundryku.controller.TransaksiController;
import com.laundryku.model.DetailLaundry;
import com.laundryku.model.LayananLaundry;
import com.laundryku.model.Pelanggan;
import com.laundryku.model.TransaksiLaundry;
import com.laundryku.util.CurrencyUtil;
import com.laundryku.util.ValidationUtil;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

/**
 * Panel untuk mengelola data Transaksi Laundry.
 * - CRUD transaksi
 * - Ubah status (DIPROSES -> DICUCI -> SELESAI -> DIAMBIL)
 * - Lihat detail transaksi + daftar laundry
 */
public class TransaksiView extends javax.swing.JPanel {

    // Controller untuk komunikasi database
    private final TransaksiController transaksiController = new TransaksiController();
    private final PelangganController pelangganController = new PelangganController();
    private final LayananController layananController = new LayananController();

    // Pilihan status transaksi
    private static final String[] STATUS_ITEMS = {"DIPROSES", "DICUCI", "SELESAI", "DIAMBIL"};

    // Nama kolom tabel
    private static final String[] TABLE_COLUMNS = {"ID", "Pelanggan", "Tgl Masuk", "Estimasi Selesai", "Status", "Total"};

    // Model tabel -- sel tidak bisa diedit langsung
    private final DefaultTableModel tableModel = new DefaultTableModel(TABLE_COLUMNS, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    // Constructor: init GUI, set combo status, model tabel, muat data.
    public TransaksiView() {
        initComponents();
        statusComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"DIPROSES", "DICUCI", "SELESAI", "DIAMBIL"}));
        transaksiTable.setModel(tableModel);
        configureTable();
        reloadComboData();
        loadData();
        wireListeners();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pelangganLabel = new javax.swing.JLabel();
        jenisPakaianLabel = new javax.swing.JLabel();
        jenisPakaianField = new javax.swing.JTextField();
        tambahButton = new javax.swing.JButton();
        ubahButton = new javax.swing.JButton();
        hapusButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        transaksiTable = new javax.swing.JTable();
        jumlahPakaianLabel = new javax.swing.JLabel();
        jumlahPakaianField = new javax.swing.JTextField();
        beratKgLabel = new javax.swing.JLabel();
        beratKgField = new javax.swing.JTextField();
        alamatLabel3 = new javax.swing.JLabel();
        pelangganComboBox = new javax.swing.JComboBox<>();
        layananComboBox = new javax.swing.JComboBox<>();
        layananLabel = new javax.swing.JLabel();
        statusComboBox = new javax.swing.JComboBox<>();
        lihatDetailButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();

        pelangganLabel.setText("Pelanggan: ");

        jenisPakaianLabel.setText("Jenis Pakaian: ");

        jenisPakaianField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenisPakaianFieldActionPerformed(evt);
            }
        });

        tambahButton.setText("Tambah");

        ubahButton.setText("Ubah");

        hapusButton.setText("Hapus");

        resetButton.setText("Reset");

        transaksiTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Pelanggan", "Tgl Masuk", "Estimasi Selesai", "Status", "Total"
            }
        ));
        jScrollPane1.setViewportView(transaksiTable);

        jumlahPakaianLabel.setText("Jumlah Pakaian: ");

        jumlahPakaianField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahPakaianFieldActionPerformed(evt);
            }
        });

        beratKgLabel.setText("Berat Kg: ");

        beratKgField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beratKgFieldActionPerformed(evt);
            }
        });

        alamatLabel3.setText("Status: ");

        pelangganComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        layananComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        layananComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                layananComboBoxActionPerformed(evt);
            }
        });

        layananLabel.setText("Layanan: ");

        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lihatDetailButton.setText("Lihat Detail");

        refreshButton.setText("Refresh");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jenisPakaianLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jenisPakaianField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jumlahPakaianLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jumlahPakaianField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(beratKgLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(beratKgField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pelangganLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pelangganComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(layananLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(layananComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tambahButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ubahButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hapusButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resetButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lihatDetailButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refreshButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(alamatLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statusComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pelangganLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pelangganComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(layananLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(layananComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jenisPakaianField)
                    .addComponent(jenisPakaianLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jumlahPakaianField)
                    .addComponent(jumlahPakaianLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(beratKgField)
                    .addComponent(beratKgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alamatLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahButton)
                    .addComponent(ubahButton)
                    .addComponent(hapusButton)
                    .addComponent(resetButton)
                    .addComponent(lihatDetailButton)
                    .addComponent(refreshButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jenisPakaianFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenisPakaianFieldActionPerformed
    }//GEN-LAST:event_jenisPakaianFieldActionPerformed

    private void jumlahPakaianFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahPakaianFieldActionPerformed
    }//GEN-LAST:event_jumlahPakaianFieldActionPerformed

    private void beratKgFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beratKgFieldActionPerformed
    }//GEN-LAST:event_beratKgFieldActionPerformed

    private void layananComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_layananComboBoxActionPerformed
    }//GEN-LAST:event_layananComboBoxActionPerformed

    // Ikat event listener ke tombol.
    private void wireListeners() {
        tambahButton.addActionListener(e -> tambah());
        ubahButton.addActionListener(e -> ubahStatus());
        hapusButton.addActionListener(e -> hapus());
        resetButton.addActionListener(e -> resetForm());
        lihatDetailButton.addActionListener(e -> lihatDetail());
        refreshButton.addActionListener(e -> { reloadComboData(); loadData(); });
    }

    // Saat baris tabel dipilih, isi combo Status.
    private void configureTable() {
        transaksiTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        transaksiTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && transaksiTable.getSelectedRow() >= 0) {
                int row = transaksiTable.getSelectedRow();
                statusComboBox.setSelectedItem(tableModel.getValueAt(row, 4).toString());
            }
        });
    }

    // Muat ulang daftar pelanggan & layanan ke combo box.
    private void reloadComboData() {
        try {
            pelangganComboBox.removeAllItems();
            layananComboBox.removeAllItems();
            for (Pelanggan pelanggan : pelangganController.getAllPelanggan()) {
                pelangganComboBox.addItem(pelanggan);
            }
            for (LayananLaundry layanan : layananController.getAllLayanan()) {
                layananComboBox.addItem(layanan);
            }
        } catch (SQLException e) {
            showError(e);
        }
    }

    // Muat ulang data transaksi dari database ke tabel.
    private void loadData() {
        try {
            tableModel.setRowCount(0);
            List<TransaksiLaundry> data = transaksiController.getAllTransaksi();
            for (TransaksiLaundry transaksi : data) {
                tableModel.addRow(new Object[]{
                        transaksi.getIdTransaksi(),
                        transaksi.getPelanggan().getNama(),
                        transaksi.getTanggalMasuk(),
                        transaksi.getTanggalSelesaiEst(),
                        transaksi.getStatus(),
                        CurrencyUtil.rupiah(transaksi.getTotal())
                });
            }
        } catch (SQLException e) {
            showError(e);
        }
    }

    // Ambil ID dari baris yang dipilih di tabel.
    private int getSelectedId() {
        int row = transaksiTable.getSelectedRow();
        if (row >= 0) {
            Object val = tableModel.getValueAt(row, 0);
            if (val != null) return Integer.parseInt(val.toString());
        }
        return -1;
    }

    // Tambah transaksi baru.
    private void tambah() {
        try {
            validateInput();
            Pelanggan pelanggan = (Pelanggan) pelangganComboBox.getSelectedItem();
            LayananLaundry layanan = (LayananLaundry) layananComboBox.getSelectedItem();
            int jumlah = ValidationUtil.parseInteger(jumlahPakaianField.getText(), "Jumlah Pakaian");
            BigDecimal berat = ValidationUtil.parseDecimal(beratKgField.getText(), "Berat Kg");
            transaksiController.tambahTransaksi(pelanggan, layanan, jenisPakaianField.getText(), jumlah, berat);
            resetForm();
            reloadComboData();
            loadData();
            JOptionPane.showMessageDialog(this, "Transaksi laundry berhasil ditambahkan.");
        } catch (Exception e) {
            showError(e);
        }
    }

    // Ubah status transaksi yang dipilih.
    private void ubahStatus() {
        try {
            int id = getSelectedId();
            if (id < 0) throw new IllegalArgumentException("Pilih transaksi terlebih dahulu.");
            transaksiController.ubahStatus(id, statusComboBox.getSelectedItem().toString());
            loadData();
            JOptionPane.showMessageDialog(this, "Status transaksi berhasil diubah.");
        } catch (Exception e) {
            showError(e);
        }
    }

    // Tampilkan popup detail transaksi (termasuk daftar laundry).
    private void lihatDetail() {
        try {
            int id = getSelectedId();
            if (id < 0) throw new IllegalArgumentException("Pilih transaksi terlebih dahulu.");
            TransaksiLaundry transaksi = transaksiController.getTransaksiDetail(id);
            if (transaksi == null) throw new IllegalArgumentException("Transaksi tidak ditemukan.");
            JTextArea area = new JTextArea(12, 45);
            area.setEditable(false);
            StringBuilder builder = new StringBuilder();
            builder.append("ID Transaksi: ").append(transaksi.getIdTransaksi()).append('\n');
            builder.append("Pelanggan: ").append(transaksi.getPelanggan().getNama()).append('\n');
            builder.append("Status: ").append(transaksi.getStatus()).append('\n');
            builder.append("Total: ").append(CurrencyUtil.rupiah(transaksi.getTotal())).append("\n\n");
            builder.append("Detail Laundry:\n");
            for (DetailLaundry detail : transaksi.getDaftarDetail()) {
                builder.append("- ").append(detail.getLayanan().getNamaLayanan())
                        .append(" | ").append(detail.getJenisPakaian())
                        .append(" | Jumlah: ").append(detail.getJumlahPakaian())
                        .append(" | Berat: ").append(detail.getBeratKg()).append(" kg")
                        .append(" | Subtotal: ").append(CurrencyUtil.rupiah(detail.getSubtotal()))
                        .append('\n');
            }
            area.setText(builder.toString());
            JOptionPane.showMessageDialog(this, new JScrollPane(area), "Detail Transaksi", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            showError(e);
        }
    }

    // Hapus transaksi setelah konfirmasi.
    private void hapus() {
        try {
            int id = getSelectedId();
            if (id < 0) throw new IllegalArgumentException("Pilih transaksi terlebih dahulu.");
            int confirm = JOptionPane.showConfirmDialog(this, "Hapus transaksi terpilih? Detail dan pembayaran terkait juga akan terhapus.", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                transaksiController.hapusTransaksi(id);
                resetForm();
                loadData();
            }
        } catch (Exception e) {
            showError(e);
        }
    }

    // Validasi field wajib.
    private void validateInput() {
        if (pelangganComboBox.getSelectedItem() == null) throw new IllegalArgumentException("Data pelanggan masih kosong. Tambahkan pelanggan terlebih dahulu.");
        if (layananComboBox.getSelectedItem() == null) throw new IllegalArgumentException("Data layanan masih kosong. Tambahkan layanan terlebih dahulu.");
        if (ValidationUtil.isBlank(jenisPakaianField.getText())) throw new IllegalArgumentException("Jenis pakaian wajib diisi.");
        if (ValidationUtil.isBlank(jumlahPakaianField.getText())) throw new IllegalArgumentException("Jumlah pakaian wajib diisi.");
        if (ValidationUtil.isBlank(beratKgField.getText())) throw new IllegalArgumentException("Berat Kg wajib diisi.");
    }

    // Kosongkan form.
    private void resetForm() {
        jenisPakaianField.setText("");
        jumlahPakaianField.setText("");
        beratKgField.setText("");
        statusComboBox.setSelectedIndex(0);
        transaksiTable.clearSelection();
    }

    // Tampilkan error dialog.
    private void showError(Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alamatLabel3;
    private javax.swing.JTextField beratKgField;
    private javax.swing.JLabel beratKgLabel;
    private javax.swing.JButton hapusButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jenisPakaianField;
    private javax.swing.JLabel jenisPakaianLabel;
    private javax.swing.JTextField jumlahPakaianField;
    private javax.swing.JLabel jumlahPakaianLabel;
    private javax.swing.JComboBox layananComboBox;
    private javax.swing.JLabel layananLabel;
    private javax.swing.JButton lihatDetailButton;
    private javax.swing.JComboBox pelangganComboBox;
    private javax.swing.JLabel pelangganLabel;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JComboBox statusComboBox;
    private javax.swing.JButton tambahButton;
    private javax.swing.JTable transaksiTable;
    private javax.swing.JButton ubahButton;
    // End of variables declaration//GEN-END:variables
}

