package com.laundryku.view;

import javax.swing.*;

// JFrame utama aplikasi LaundryKu.
// Berisi judul dan JTabbedPane dengan 4 tab: Pelanggan, Layanan, Transaksi, Pembayaran.
public class MainFrame extends javax.swing.JFrame {

    // Constructor: init komponen GUI lalu tambah 4 tab ke panel utama.
    public MainFrame() {
        initComponents();
        setTitle("LaundryKu - Sistem Manajemen Laundry MVC");
        setSize(1100, 720);
        setLocationRelativeTo(null);
        // Tambah 4 tab ke JTabbedPane
        mainView.addTab("Pelanggan", new PelangganView());
        mainView.addTab("Layanan", new LayananView());
        mainView.addTab("Transaksi", new TransaksiView());
        mainView.addTab("Pembayaran", new PembayaranView());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        mainView = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Sistem Manajemen Laundry");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(title)
                .addContainerGap(238, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainView)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainView, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane mainView;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
