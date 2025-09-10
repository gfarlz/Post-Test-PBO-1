package com.mycompany.pbo_post_test1;

import java.util.ArrayList;
import java.util.Scanner;

public class PenyaluranDonasi {
    private static ArrayList<Donasi> listDonasi = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int nextId = 1;
    
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
    
    private static void initializeData() {
        listDonasi.add(new Donasi(nextId++, "Timothy Ronald", 50000000, "01/09/2024", "Panti Asuhan Harapan", "Tersalurkan"));
        listDonasi.add(new Donasi(nextId++, "Ahmad Sahroni", 25000, "05/09/2024", "Masjid Al-Ikhlas", "Menunggu"));
        listDonasi.add(new Donasi(nextId++, "Ali Le'ey", 5000000, "10/09/2024", "Korban Bencana Alam", "Tersalurkan"));
    }
    
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
    
    private static Donasi cariDonasiById(int id) {
        for (Donasi donasi : listDonasi) {
            if (donasi.getId() == id) {
                return donasi;
            }
        }
        return null;
    }
}

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

