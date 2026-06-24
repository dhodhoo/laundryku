CREATE DATABASE IF NOT EXISTS laundryku_db;
USE laundryku_db;

DROP TABLE IF EXISTS pembayaran;
DROP TABLE IF EXISTS detail_laundry;
DROP TABLE IF EXISTS transaksi_laundry;
DROP TABLE IF EXISTS layanan_laundry;
DROP TABLE IF EXISTS pelanggan;

CREATE TABLE pelanggan (
    id_pelanggan INT AUTO_INCREMENT PRIMARY KEY,
    nama VARCHAR(100) NOT NULL,
    no_hp VARCHAR(20) NOT NULL,
    alamat TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE layanan_laundry (
    id_layanan INT AUTO_INCREMENT PRIMARY KEY,
    nama_layanan VARCHAR(100) NOT NULL,
    harga_per_kg DECIMAL(12,2) NOT NULL,
    estimasi_hari INT NOT NULL
);

CREATE TABLE transaksi_laundry (
    id_transaksi INT AUTO_INCREMENT PRIMARY KEY,
    id_pelanggan INT NOT NULL,
    tanggal_masuk DATE NOT NULL,
    tanggal_selesai_est DATE NOT NULL,
    status ENUM('DIPROSES', 'DICUCI', 'SELESAI', 'DIAMBIL') DEFAULT 'DIPROSES',
    total DECIMAL(12,2) DEFAULT 0,
    CONSTRAINT fk_transaksi_pelanggan
        FOREIGN KEY (id_pelanggan) REFERENCES pelanggan(id_pelanggan)
        ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE detail_laundry (
    id_detail INT AUTO_INCREMENT PRIMARY KEY,
    id_transaksi INT NOT NULL,
    id_layanan INT NOT NULL,
    jenis_pakaian VARCHAR(100) NOT NULL,
    jumlah_pakaian INT NOT NULL,
    berat_kg DECIMAL(8,2) NOT NULL,
    subtotal DECIMAL(12,2) NOT NULL,
    CONSTRAINT fk_detail_transaksi
        FOREIGN KEY (id_transaksi) REFERENCES transaksi_laundry(id_transaksi)
        ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_detail_layanan
        FOREIGN KEY (id_layanan) REFERENCES layanan_laundry(id_layanan)
        ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE pembayaran (
    id_pembayaran INT AUTO_INCREMENT PRIMARY KEY,
    id_transaksi INT NOT NULL UNIQUE,
    tanggal_bayar DATE NOT NULL,
    metode ENUM('TUNAI', 'TRANSFER', 'QRIS', 'DEBIT') NOT NULL,
    jumlah_bayar DECIMAL(12,2) NOT NULL,
    status ENUM('BELUM_LUNAS', 'LUNAS') NOT NULL,
    CONSTRAINT fk_pembayaran_transaksi
        FOREIGN KEY (id_transaksi) REFERENCES transaksi_laundry(id_transaksi)
        ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO pelanggan (nama, no_hp, alamat) VALUES
('Andi Pratama', '081234567890', 'Jl. Telekomunikasi No. 1'),
('Siti Rahma', '082233445566', 'Jl. Sukapura No. 10'),
('Budi Santoso', '083344556677', 'Jl. Bojongsoang No. 5');

INSERT INTO layanan_laundry (nama_layanan, harga_per_kg, estimasi_hari) VALUES
('Cuci Kering', 7000, 2),
('Cuci Setrika', 10000, 3),
('Express 1 Hari', 15000, 1),
('Laundry Sepatu', 25000, 4);

INSERT INTO transaksi_laundry (id_pelanggan, tanggal_masuk, tanggal_selesai_est, status, total) VALUES
(1, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 2 DAY), 'DIPROSES', 35000);

INSERT INTO detail_laundry (id_transaksi, id_layanan, jenis_pakaian, jumlah_pakaian, berat_kg, subtotal) VALUES
(1, 1, 'Kaos dan Celana', 8, 5.00, 35000);

INSERT INTO pembayaran (id_transaksi, tanggal_bayar, metode, jumlah_bayar, status) VALUES
(1, CURDATE(), 'TUNAI', 35000, 'LUNAS');
