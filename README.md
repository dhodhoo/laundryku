# LaundryKu MVC

LaundryKu MVC adalah project tugas besar Java desktop untuk mata kuliah Pemrograman Berorientasi Objek. Project ini mengimplementasikan:

- Asosiasi
- Agregasi
- Komposisi
- JDBC
- GUI Java Swing
- Koneksi database MySQL
- Arsitektur Model-View-Controller atau MVC
- Query CRUD: Create, Retrieve, Update, Delete

## Fitur Aplikasi

1. Kelola pelanggan
   - Tambah pelanggan
   - Tampilkan data pelanggan
   - Ubah data pelanggan
   - Hapus data pelanggan

2. Kelola layanan laundry
   - Tambah layanan
   - Tampilkan layanan
   - Ubah layanan
   - Hapus layanan

3. Kelola transaksi laundry
   - Tambah transaksi laundry
   - Tampilkan transaksi
   - Lihat detail transaksi
   - Ubah status laundry: DIPROSES, DICUCI, SELESAI, DIAMBIL
   - Hapus transaksi

4. Kelola pembayaran
   - Tambah pembayaran
   - Tampilkan pembayaran
   - Ubah pembayaran
   - Hapus pembayaran
   - Status pembayaran otomatis: LUNAS atau BELUM_LUNAS

## Teknologi

- Java 17
- Swing
- JDBC
- MySQL
- Maven
- MySQL Connector/J

## Struktur Project

```text
laundryku-mvc/
├── database/
│   └── laundryku_db.sql
├── docs/
│   └── MATERI_OOP.md
├── src/main/java/com/laundryku/
│   ├── Main.java
│   ├── config/
│   │   └── DatabaseConnection.java
│   ├── model/
│   │   ├── Pelanggan.java
│   │   ├── LayananLaundry.java
│   │   ├── DetailLaundry.java
│   │   ├── TransaksiLaundry.java
│   │   ├── Pembayaran.java
│   │   └── Laundry.java
│   ├── dao/
│   │   ├── PelangganDAO.java
│   │   ├── LayananDAO.java
│   │   ├── TransaksiDAO.java
│   │   └── PembayaranDAO.java
│   ├── controller/
│   │   ├── PelangganController.java
│   │   ├── LayananController.java
│   │   ├── TransaksiController.java
│   │   └── PembayaranController.java
│   ├── view/
│   │   ├── MainFrame.java
│   │   ├── PelangganView.java
│   │   ├── LayananView.java
│   │   ├── TransaksiView.java
│   │   └── PembayaranView.java
│   └── util/
│       ├── CurrencyUtil.java
│       └── ValidationUtil.java
└── pom.xml
```

## Cara Menjalankan

### 1. Siapkan Database

Buka MySQL/phpMyAdmin, lalu import file:

```text
database/laundryku_db.sql
```

File tersebut akan membuat database bernama:

```text
laundryku_db
```

### 2. Atur Koneksi Database

Buka file:

```text
src/main/java/com/laundryku/config/DatabaseConnection.java
```

Sesuaikan bagian berikut jika username/password MySQL berbeda:

```java
private static final String URL = "jdbc:mysql://localhost:3306/laundryku_db?useSSL=false&serverTimezone=Asia/Jakarta";
private static final String USER = "root";
private static final String PASSWORD = "";
```

### 3. Jalankan Project

Jika menggunakan NetBeans atau IntelliJ IDEA:

1. Buka folder project `laundryku-mvc`.
2. Pastikan Maven dependency sudah terunduh.
3. Jalankan class `com.laundryku.Main`.

Jika menggunakan terminal:

```bash
mvn clean compile
mvn exec:java
```

## Catatan Penting

- Jika muncul error MySQL Connector/J, pastikan Maven sudah berhasil mengunduh dependency.
- Jika koneksi gagal, pastikan MySQL berjalan dan database `laundryku_db` sudah dibuat.
- Project ini sudah memakai PreparedStatement agar query lebih aman dan rapi.
- GUI dibuat manual menggunakan Java Swing agar tetap mudah dipahami dan bisa dikembangkan dengan drag & drop komponen di NetBeans.
