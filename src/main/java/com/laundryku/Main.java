package com.laundryku;

import com.laundryku.view.MainFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

// Titik masuk utama aplikasi LaundryKu
public class Main {
    public static void main(String[] args) {
        // Jalankan pembuatan GUI di thread khusus Swing
        SwingUtilities.invokeLater(() -> {
            try {
                // Pakai tema sistem operasi (Windows/Linux/Mac)
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {
                // Kalau gagal, pakai tema default Java
            }
            // Tampilkan jendela utama
            new MainFrame().setVisible(true);
        });
    }
}
