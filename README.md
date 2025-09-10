# Post-Test-PBO-1

### Nama: Ghifari Al Azhar
### NIM: 2409116059

## Deskripsi Singkat 
Program ini adalah aplikasi berbasis console untuk mengelola data penyaluran donasi uang. Program menggunakan konsep CRUD (Create, Read, Update, Delete) dengan struktur data ArrayList untuk menyimpan informasi donatur dan penerima donasi. Program dirancang dengan menu interaktif yang memungkinkan pengguna untuk mengelola data donasi secara mudah.

## Alur Program
Program dimulai dari:
- Masuk ke menu utama.
- Pilihan menu terdiri dari tampilkan data donasi, tambah donasi, edit donasi, hapus donasi, dan keluar dari program.
- Pilihan tambah donasi akan meminta kita mengisi data donasi seperti nama donatur, jumlah donasi, tanggal, penerima, dan status. Jika sudah diisi, data akan tersimpan ke dalam program.
- Pilihan tampilkan data donasi akan menampilkan semua data donasi yang tersedia beserta total jumlah nominal donasi.
- Pilihan edit donasi akan menampilkan semua data donasi yang tersedia, lalu diminta memilih ID donasi yang ingin diubah. Setelah itu kita bisa memperbarui data sesuai kebutuhan.
- Pilihan hapus donasi akan menampilkan semua data donasi, lalu diminta memilih ID donasi yang ingin dihapus. Setelah dikonfirmasi, data akan dihapus dari program.
- Pilihan keluar akan menutup program dengan menampilkan pesan terima kasih.

## Penjelasan Code

#### 1. Import Library
```bash
import java.util.ArrayList;
import java.util.Scanner;
```
- ArrayList → digunakan untuk menyimpan kumpulan data donasi dalam bentuk list yang fleksibel.
- Scanner → dipakai untuk membaca input dari pengguna di console.

#### 2. Deklarasi Kelas Utama
```bash
public class PenyaluranDonasi {
    private static ArrayList<Donasi> listDonasi = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int nextId = 1;
```
- listDonasi → tempat menyimpan semua data donasi.
- scanner → objek untuk membaca input dari user.
- nextId → digunakan agar setiap donasi memiliki ID unik yang terus bertambah otomatis.

#### 3. Method Main ()
```bash
    public static void main(String[] args) {
        initializeData();
        
        boolean running = true;
        while (running) {
            tampilkanMenu();
            System.out.print("Pilih menu (1-5): ");
            int pilihan = Integer.parseInt(scanner.nextLine());
            
            switch (pilihan) {
                case 1:
                    tampilkanSemuaDonasi();
                    break;
                case 2:
                    tambahDonasi();
                    break;
                case 3:
                    editDonasi();
                    break;
                case 4:
                    hapusDonasi();
                    break;
                case 5:
                    System.out.println("\n=== TERIMA KASIH ===");
                    System.out.println("Program selesai. Semoga donasi bermanfaat!");
                    running = false;
                    break;
                default:
                    System.out.println("\nPilihan tidak valid! Silakan pilih 1-5.");
            }
            
            if (running) {
                System.out.println("\nTekan Enter untuk melanjutkan...");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
```
- initializeData() → mengisi data awal (dummy data) agar program tidak kosong ketika pertama kali dijalankan.
- Program berjalan dalam looping while (running) agar menu bisa terus tampil sampai user memilih keluar.
- Di dalamnya ada menu pilihan (1–5):
   - Tampilkan semua data donasi
   - Tambah data donasi
   - Edit data donasi
   - Hapus data donasi
   - Keluar dari program

#### 4. Inisialisasi Data
```bash
    private static void initializeData() {
        listDonasi.add(new Donasi(nextId++, "Timothy Ronald", 50000000, "01/09/2024", "Panti Asuhan Harapan", "Tersalurkan"));
        listDonasi.add(new Donasi(nextId++, "Ahmad Sahroni", 25000, "05/09/2024", "Masjid Al-Ikhlas", "Menunggu"));
        listDonasi.add(new Donasi(nextId++, "Ali Le'ey", 5000000, "10/09/2024", "Korban Bencana Alam", "Tersalurkan"));
    }
```
- Digunakan untuk mengisi data donasi contoh (dummy) agar user bisa langsung melihat isi daftar donasi ketika program pertama kali dijalankan.
- nextId++ memastikan ID donasi bertambah otomatis.

#### 5. Tampilkan Menu
```bash
    private static void tampilkanMenu() {
        System.out.println("\n========================================");
        System.out.println("    SISTEM MANAJEMEN PENYALURAN DONASI");
        System.out.println("========================================");
        System.out.println("1. Tampilkan Semua Data Donasi");
        System.out.println("2. Tambah Data Donasi");
        System.out.println("3. Edit Data Donasi");
        System.out.println("4. Hapus Data Donasi");
        System.out.println("5. Keluar");
        System.out.println("========================================");
    }
```
- Menampilkan daftar pilihan yang bisa dipilih user

#### 6. Tampilkan Semua Donasi
```bash
    private static void tampilkanSemuaDonasi() {
        System.out.println("\n=== DAFTAR PENYALURAN DONASI ===");
        
        if (listDonasi.isEmpty()) {
            System.out.println("Tidak ada data donasi yang tersedia.");
        } else {
            for (int i = 0; i < listDonasi.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, listDonasi.get(i).toString());
            }
            System.out.println("-------------------------------------");
            System.out.printf("Total Donasi: %d item%n", listDonasi.size());
            
            double totalUang = 0;
            for (Donasi donasi : listDonasi) {
                totalUang += donasi.getJumlahDonasi();
            }
            System.out.printf("Total Donasi Uang: Rp %.2f%n", totalUang);
        }
    }
```
- Jika tidak ada data → tampilkan pesan kosong.
- Jika ada → ditampilkan semua donasi lengkap dengan ID, nama donatur, jumlah, tanggal, penerima, dan status.
- Program juga menghitung:
   - Jumlah item donasi
   - Total uang donasi (semua jumlah donasi dijumlahkan).
 
#### 7. Tambah Donasi
```bash
    private static void tambahDonasi() {
        System.out.println("\n=== TAMBAH DATA DONASI ===");
        
        System.out.print("Nama Donatur: ");
        String namaDonatur = scanner.nextLine();
        
        System.out.print("Jumlah Donasi (Rp): ");
        double jumlahDonasi = Double.parseDouble(scanner.nextLine());
        
        System.out.print("Tanggal Donasi (DD/MM/YYYY): ");
        String tanggalDonasi = scanner.nextLine();
        
        System.out.print("Penerima Donasi: ");
        String penerima = scanner.nextLine();
        
        System.out.print("Status (Menunggu/Tersalurkan): ");
        String status = scanner.nextLine();
        
        Donasi donasiBaru = new Donasi(nextId++, namaDonatur, jumlahDonasi, tanggalDonasi, penerima, status);
        listDonasi.add(donasiBaru);
        
        System.out.println("\nData donasi berhasil ditambahkan!");
        System.out.println("ID Donasi: " + donasiBaru.getId());
    }
```
- Meminta input dari user: nama donatur, jumlah, tanggal, penerima, dan status.
- Setelah itu data disimpan dalam listDonasi dengan ID otomatis dari nextId++.

#### 8. Edit Donasi
```bash
    private static void editDonasi() {
        System.out.println("\n=== EDIT DATA DONASI ===");
        
        tampilkanSemuaDonasi();
        System.out.print("\nMasukkan ID donasi yang akan diedit: ");
        int id = Integer.parseInt(scanner.nextLine());
        
        Donasi donasi = cariDonasiById(id);
        
        System.out.println("\nData saat ini:");
        System.out.println(donasi.toString());
        
        System.out.print("Nama Donatur [" + donasi.getNamaDonatur() + "]: ");
        String namaDonatur = scanner.nextLine();
        if (!namaDonatur.trim().isEmpty()) {
            donasi.setNamaDonatur(namaDonatur);
        }
        
        System.out.print("Jumlah Donasi [" + donasi.getJumlahDonasi() + "]: ");
        String jumlahStr = scanner.nextLine();
        if (!jumlahStr.trim().isEmpty()) {
            double jumlah = Double.parseDouble(jumlahStr);
            donasi.setJumlahDonasi(jumlah);
        }
        
        System.out.print("Tanggal Donasi [" + donasi.getTanggalDonasi() + "]: ");
        String tanggalDonasi = scanner.nextLine();
        if (!tanggalDonasi.trim().isEmpty()) {
            donasi.setTanggalDonasi(tanggalDonasi);
        }
        
        System.out.print("Penerima Donasi [" + donasi.getPenerima() + "]: ");
        String penerima = scanner.nextLine();
        if (!penerima.trim().isEmpty()) {
            donasi.setPenerima(penerima);
        }
        
        System.out.print("Status [" + donasi.getStatus() + "]: ");
        String status = scanner.nextLine();
        if (!status.trim().isEmpty()) {
            donasi.setStatus(status);
        }
        
        System.out.println("\nData donasi berhasil diperbarui!");
    }
```
- User memilih ID donasi yang ingin diedit.
- Ditampilkan data lama, lalu user bisa mengganti sebagian data (atau menekan Enter untuk tidak mengubah).
- Data yang diubah akan langsung diperbarui.

#### 9. Hapus Donasi
```bash
    private static void hapusDonasi() {
        System.out.println("\n=== HAPUS DATA DONASI ===");
        
        tampilkanSemuaDonasi();
        System.out.print("\nMasukkan ID donasi yang akan dihapus: ");
        int id = Integer.parseInt(scanner.nextLine());
        
        Donasi donasi = cariDonasiById(id);
        
        System.out.println("\nData yang akan dihapus:");
        System.out.println(donasi.toString());
        
        System.out.print("\nApakah Anda yakin ingin menghapus data ini? (y/n): ");
        String konfirmasi = scanner.nextLine();
        
        if (konfirmasi.equalsIgnoreCase("y")) {
            listDonasi.remove(donasi);
            System.out.println("Data donasi berhasil dihapus!");
        } else {
            System.out.println("Penghapusan dibatalkan.");
        }
    }
```
- User memilih ID donasi yang ingin dihapus.
- Program meminta konfirmasi (y/n) sebelum menghapus data agar tidak salah hapus.

#### 10. Mencari Donasi Berdasarkan ID
```bash
    private static Donasi cariDonasiById(int id) {
        for (Donasi donasi : listDonasi) {
            if (donasi.getId() == id) {
                return donasi;
            }
        }
        return null;
    }
}
```
- Digunakan oleh fitur **Edit** dan **Hapus** untuk menemukan donasi berdasarkan ID

#### 11. Kelas Donsai
```bash
class Donasi {
    private int id;
    private String namaDonatur;
    private double jumlahDonasi;
    private String tanggalDonasi;
    private String penerima;
    private String status;
    
    public Donasi(int id, String namaDonatur, double jumlahDonasi, String tanggalDonasi, String penerima, String status) {
        this.id = id;
        this.namaDonatur = namaDonatur;
        this.jumlahDonasi = jumlahDonasi;
        this.tanggalDonasi = tanggalDonasi;
        this.penerima = penerima;
        this.status = status;
    }
    
    public int getId() { return id; }
    public String getNamaDonatur() { return namaDonatur; }
    public double getJumlahDonasi() { return jumlahDonasi; }
    public String getTanggalDonasi() { return tanggalDonasi; }
    public String getPenerima() { return penerima; }
    public String getStatus() { return status; }
    
    public void setNamaDonatur(String namaDonatur) { this.namaDonatur = namaDonatur; }
    public void setJumlahDonasi(double jumlahDonasi) { this.jumlahDonasi = jumlahDonasi; }
    public void setTanggalDonasi(String tanggalDonasi) { this.tanggalDonasi = tanggalDonasi; }
    public void setPenerima(String penerima) { this.penerima = penerima; }
    public void setStatus(String status) { this.status = status; }
    
    @Override
    public String toString() {
        return String.format("ID: %d | Donatur: %s | Jumlah: Rp %.2f | Tanggal: %s | Penerima: %s | Status: %s",
                           id, namaDonatur, jumlahDonasi, tanggalDonasi, penerima, status);
    }
}
```
- Atribut: id, namaDonatur, jumlahDonasi, tanggalDonasi, penerima, status.
- Getter dan Setter: untuk membaca dan mengubah data donasi.
- toString(): menampilkan data donasi dalam format yang rapi


## Penjelasan OutPut
1. <img width="464" height="257" alt="image" src="https://github.com/user-attachments/assets/c3709432-3cfa-43dd-8591-27455aa89a3c" />
OutPut menu pertama ada 5 yaitu:
   - Dampilkan Demua Data Donasi
   - Dambah Data Donasi
   - Ddit Data Donasi
   - Hapus Data Donasi
   - Keluar

2. <img width="1510" height="243" alt="image" src="https://github.com/user-attachments/assets/8c057cf8-b7fc-427c-bd6a-16dad679f910" />
Output ini meminta pengguna mengisi data donasi baru seperti nama donatur, jumlah, tanggal, penerima, dan status, lalu menyimpannya ke dalam daftar donasi dengan ID otomatis.

3. <img width="518" height="290" alt="image" src="https://github.com/user-attachments/assets/68e5d4b4-fa2a-44a8-9fce-331c124250cf" />
Output ini menampilkan daftar donasi, lalu meminta pengguna memilih ID donasi yang ingin diubah, kemudian data tersebut dapat diperbarui sesuai input baru dari pengguna.

4. <img width="1531" height="641" alt="image" src="https://github.com/user-attachments/assets/8939d2eb-383a-4e5b-bb47-1ce6f8b92ffd" />
Output ini menampilkan daftar donasi yang tersedia, lalu meminta ID donasi yang ingin dihapus, dan setelah dipilih dan diisi dengan data baru program akan menghapus data tersebut dari daftar.

5. <img width="1531" height="532" alt="image" src="https://github.com/user-attachments/assets/fe97ec0f-d349-430d-9ee9-4925b1e92f27" />
Output ini menampilkan daftar donasi yang tersedia, lalu meminta ID donasi yang ingin dihapus. Setelah pengguna memilih ID 2 dan mengonfirmasi dengan jawaban "y", program menghapus data tersebut dan menampilkan pesan bahwa donasi berhasil dihapus.

6. <img width="815" height="182" alt="image" src="https://github.com/user-attachments/assets/b8f3280b-7cae-4db0-8144-ce04af83b928" />
Output ini menampilkan pesan penutup berupa ucapan terima kasih, kemudian program berhenti dengan status selesai.
