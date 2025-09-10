# Post-Test-PBO-1

### Nama: Ghifari Al Azhar
### NIM: 2409116059

## Deskripsi Singkat 
Program ini adalah aplikasi berbasis console untuk mengelola data penyaluran donasi uang. Program menggunakan konsep CRUD (Create, Read, Update, Delete) dengan struktur data ArrayList untuk menyimpan informasi donatur dan penerima donasi. Program dirancang dengan menu interaktif yang memungkinkan pengguna untuk mengelola data donasi secara mudah.

##Alur Program
Program dimulai dari:
-Masuk ke menu utama.
-Pilihan menu terdiri dari tampilkan data donasi, tambah donasi, edit donasi, hapus donasi, dan keluar dari program.
-Pilihan tambah donasi akan meminta kita mengisi data donasi seperti nama donatur, jumlah donasi, tanggal, penerima, dan status. Jika sudah diisi, data akan tersimpan ke dalam program.
-Pilihan tampilkan data donasi akan menampilkan semua data donasi yang tersedia beserta total jumlah nominal donasi.
-Pilihan edit donasi akan menampilkan semua data donasi yang tersedia, lalu diminta memilih ID donasi yang ingin diubah. Setelah itu kita bisa memperbarui data sesuai kebutuhan.
-Pilihan hapus donasi akan menampilkan semua data donasi, lalu diminta memilih ID donasi yang ingin dihapus. Setelah dikonfirmasi, data akan dihapus dari program.
-Pilihan keluar akan menutup program dengan menampilkan pesan terima kasih.

## Penjelasan Code
```bash
import java.util.ArrayList;
import java.util.Scanner;
```
