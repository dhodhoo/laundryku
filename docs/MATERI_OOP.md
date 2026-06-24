# Pemetaan Materi OOP pada Project LaundryKu

## 1. Asosiasi

Asosiasi terjadi ketika dua class saling berhubungan, tetapi keduanya tetap dapat berdiri sendiri.

Contoh pada project:

```java
public class TransaksiLaundry {
    private Pelanggan pelanggan;
}
```

Maknanya: satu pelanggan dapat melakukan transaksi laundry. Objek `Pelanggan` tetap dapat ada walaupun transaksi belum dibuat.

## 2. Agregasi

Agregasi adalah relasi whole-part yang lebih lemah. Objek bagian tetap dapat hidup meskipun objek utama tidak digunakan.

Contoh pada project:

```java
public class Laundry {
    private final List<LayananLaundry> daftarLayanan = new ArrayList<>();
}
```

Maknanya: laundry memiliki banyak layanan, tetapi data layanan seperti `Cuci Kering` atau `Cuci Setrika` tetap dapat dikelola secara mandiri.

## 3. Komposisi

Komposisi adalah relasi whole-part yang kuat. Objek bagian bergantung pada objek utama.

Contoh pada project:

```java
public class TransaksiLaundry {
    private final List<DetailLaundry> daftarDetail = new ArrayList<>();
}
```

Maknanya: detail laundry merupakan bagian dari transaksi. Jika transaksi dihapus, detailnya juga ikut terhapus melalui aturan `ON DELETE CASCADE` di database.

## 4. JDBC

JDBC digunakan pada package `dao` untuk menjalankan query SQL ke MySQL.

Contoh file:

- `PelangganDAO.java`
- `LayananDAO.java`
- `TransaksiDAO.java`
- `PembayaranDAO.java`

Semua query menggunakan `PreparedStatement`.

## 5. GUI Swing

GUI terdapat pada package `view`.

Komponen yang digunakan:

- `JFrame`
- `JPanel`
- `JTabbedPane`
- `JTable`
- `JTextField`
- `JTextArea`
- `JComboBox`
- `JButton`
- `JOptionPane`

## 6. Arsitektur MVC

Project dipisahkan menjadi beberapa layer:

- `model`: representasi data dan logika object
- `view`: tampilan Swing
- `controller`: penghubung view dan DAO
- `dao`: akses database menggunakan JDBC
- `config`: koneksi database
- `util`: helper validasi dan format uang

## 7. CRUD

CRUD diterapkan pada:

- Pelanggan
- Layanan laundry
- Transaksi laundry
- Pembayaran

## 8. Status Laundry

Status laundry menggunakan nilai:

- DIPROSES
- DICUCI
- SELESAI
- DIAMBIL

Status dapat diubah melalui tab Transaksi.
