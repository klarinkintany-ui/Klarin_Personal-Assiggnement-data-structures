import java.util.Scanner;

/**
 * Main Class - Program utama pengelolaan data mahasiswa
 * Menggabungkan Soal 1, 2, dan 3 dalam satu program
 */
public class Main {

    public static void main(String[] args) {

        // ============================================================
        // SOAL 1: Membuat 10 objek Mahasiswa dan menyimpan ke array
        // ============================================================
        Mahasiswa[] daftar = new Mahasiswa[10]; // Array untuk menyimpan data 10 mahasiswa

        // Inisialisasi data 10 mahasiswa menggunakan constructor
        daftar[0] = new Mahasiswa("Klarin Kintany",  "2440001", "Computer Science", 3.95);
        daftar[1] = new Mahasiswa("Rachel Venya",    "2440002", "Information Systems",   3.40);
        daftar[2] = new Mahasiswa("Fuji astuti",     "2440003", "Computer Engineering", 3.70);
        daftar[3] = new Mahasiswa("Erika Carlina",   "2440004", "Industrial Engineering",    3.00);
        daftar[4] = new Mahasiswa("Lisa Blackpink",  "2440005", "Accounting",          3.20);
        daftar[5] = new Mahasiswa("Jisoo Blackpink", "2440006", "Business Administration", 3.10);
        daftar[6] = new Mahasiswa("Jennie Blackpink","2440007", "Marketing",           3.50);
        daftar[7] = new Mahasiswa("Rose Blackpink",  "2440008", "Finance",             3.80);
        daftar[8] = new Mahasiswa("BTS RM",          "2440009", "Music Production",    3.90);
        daftar[9] = new Mahasiswa("BTS Jin",         "2440010", "Acting",              3.85);
       


        // Menampilkan seluruh data mahasiswa menggunakan loop
        System.out.println("=== Data Mahasiswa ===");
        for (Mahasiswa m : daftar) {
            m.tampilkanInfo();
            System.out.println(); // baris kosong antar mahasiswa
        }

        // ============================================================
        // SOAL 2: Enkapsulasi - Update IPK menggunakan input pengguna
        // ============================================================
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan NIM mahasiswa yang ingin diupdate: ");
        String nimInput = scanner.nextLine().trim();

        // Cari mahasiswa berdasarkan NIM
        Mahasiswa target = null;
        for (Mahasiswa m : daftar) {
            if (m.getNim().equals(nimInput)) {
                target = m;
                break;
            }
        }

        if (target != null) {
            System.out.print("Masukkan IPK baru: ");
            double ipkBaru = scanner.nextDouble();

            // Memperbarui IPK melalui method updateIpk (enkapsulasi)
            target.updateIpk(ipkBaru);

            // ============================================================
            // SOAL 3: Menampilkan info lengkap + status + predikat akademik
            // ============================================================
            System.out.println();
            System.out.println("=== Data Mahasiswa ===");
            target.tampilkanInfo();
            System.out.println("Status  : " + target.cekKelulusan());
            System.out.println("Predikat: " + target.hitungPredikat());

        } else {
            System.out.println("Mahasiswa dengan NIM " + nimInput + " tidak ditemukan.");
        }

        scanner.close();
    }
}
