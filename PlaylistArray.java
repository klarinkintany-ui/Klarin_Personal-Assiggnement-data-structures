import java.util.Scanner;

/*
 * Tugas Kelompok ke-2 -Data Structures and Algorithm Analysis
 * Nama     : Klarin Kintany    /NIM : 2902785173 /Group : 6
 * Nama     : Dzaky Aprilliano  /NIM : 2902783754 /Group : 6
 * Nama     : Devia Nurfitriana /NIM : 2902775784 /Group : 6
 * Program ini mengimplementasikan operasi dasar Array (Traversal, Searching,
 * Insertion, Deletion) pada sistem manajemen playlist musik sederhana,
 * serta fitur tambahan sorting (Bubble Sort) berdasarkan durasi lagu.
 */

class Lagu {
    private String judul;
    private String artis;
    private double durasi; // dalam satuan menit, format menit.detik (contoh 4.23 = 4 menit 23 detik)

    public Lagu(String judul, String artis, double durasi) {
        this.judul = judul;
        this.artis = artis;
        this.durasi = durasi;
    }

    public String getJudul() {
        return judul;
    }

    public double getDurasi() {
        return durasi;
    }

    // Menampilkan informasi lagu dengan format yang rapi
    public void tampilkanInfo() {
        System.out.printf("%s - %s (%.2f menit)%n", judul, artis, durasi);
    }
}

public class PlaylistArray {

    private Lagu[] playlist;
    private int jumlahLagu; // jumlah lagu yang sedang tersimpan di array
    private static final int KAPASITAS_MAKS = 10;

    public PlaylistArray() {
        playlist = new Lagu[KAPASITAS_MAKS];
        jumlahLagu = 0;
    }

    /*1
    
     * TRAVERSAL 
     * Kompleksitas: O(n)
     * Menelusuri seluruh elemen array dari indeks 0 sampai jumlahLagu-1
     * untuk menampilkan setiap data lagu.
     */
    public void tampilkanSemuaLagu() {
        System.out.println("Daftar lagu saat ini:");
        if (jumlahLagu == 0) {
            System.out.println("(Playlist masih kosong)");
            return;
        }
        for (int i = 0; i < jumlahLagu; i++) {
            System.out.print((i + 1) + ". ");
            playlist[i].tampilkanInfo();
        }
    }

    /*
     *  INSERTION 
     * Kompleksitas: O(1) (insert selalu di posisi akhir array, tanpa pergeseran)
     * Menambahkan lagu baru ke akhir array, setelah memeriksa apakah
     * playlist sudah penuh (kapasitas maksimum 10).
     */
    public void tambahLagu(Scanner scanner) {
        if (jumlahLagu >= KAPASITAS_MAKS) {
            System.out.println("Playlist sudah penuh! Tidak dapat menambah lagu baru.");
            return;
        }

        System.out.print("Masukkan judul lagu : ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan artis      : ");
        String artis = scanner.nextLine();
        System.out.print("Masukkan durasi (menit): ");
        double durasi = Double.parseDouble(scanner.nextLine());

        playlist[jumlahLagu] = new Lagu(judul, artis, durasi);
        jumlahLagu++;

        System.out.println("Lagu berhasil ditambahkan!");
        tampilkanSemuaLagu();
    }

    /*
     *  DELETION 
     * Kompleksitas: O(n) (pencarian indeks linear + pergeseran elemen
     * setelahnya agar data tetap rapat/tidak ada slot kosong di tengah)
     * Menghapus lagu berdasarkan judul yang dimasukkan pengguna.
     */
    public void hapusLagu(Scanner scanner) {
        if (jumlahLagu == 0) {
            System.out.println("Playlist masih kosong, tidak ada yang bisa dihapus.");
            return;
        }

        System.out.print("Masukkan judul lagu yang ingin dihapus: ");
        String judul = scanner.nextLine();

        int indexDitemukan = -1;
        for (int i = 0; i < jumlahLagu; i++) {
            if (playlist[i].getJudul().equalsIgnoreCase(judul)) {
                indexDitemukan = i;
                break;
            }
        }

        if (indexDitemukan == -1) {
            System.out.println("Lagu dengan judul \"" + judul + "\" tidak ditemukan.");
            return;
        }

        // Geser semua elemen setelah indexDitemukan satu posisi ke kiri
        for (int i = indexDitemukan; i < jumlahLagu - 1; i++) {
            playlist[i] = playlist[i + 1];
        }
        playlist[jumlahLagu - 1] = null; // kosongkan slot terakhir yang sudah tidak terpakai
        jumlahLagu--;

        System.out.println("Lagu berhasil dihapus!");
        tampilkanSemuaLagu();
    }

    /*
     * SEARCHING (Linear Search)
     * Kompleksitas: O(n)
     * Mencari lagu berdasarkan judul dengan menelusuri array satu per satu
     * dari awal hingga ditemukan atau seluruh elemen telah diperiksa.
     */
    public void cariLagu(Scanner scanner) {
        if (jumlahLagu == 0) {
            System.out.println("Playlist masih kosong.");
            return;
        }

        System.out.print("Masukkan judul lagu yang dicari: ");
        String judul = scanner.nextLine();

        for (int i = 0; i < jumlahLagu; i++) {
            if (playlist[i].getJudul().equalsIgnoreCase(judul)) {
                System.out.println("Lagu ditemukan di posisi " + (i + 1) + ":");
                playlist[i].tampilkanInfo();
                return;
            }
        }
        System.out.println("Lagu dengan judul \"" + judul + "\" tidak ditemukan.");
    }

    /*
     * FITUR TAMBAHAN: SORTING (Bubble Sort) 
     * Kompleksitas: O(n^2)
     * Bubble Sort termasuk kategori O(n^2) karena menggunakan dua buah
     * perulangan bersarang (nested loop): perulangan luar berjalan sebanyak
     * n kali, dan untuk setiap iterasi luar, perulangan dalam membandingkan
     * serta menukar pasangan elemen yang berdekatan sebanyak (n-1), (n-2),
     * ... kali. Total perbandingan kurang lebih n*(n-1)/2, yang termasuk
     * dalam orde n^2 untuk kasus rata-rata maupun terburuk.
     */
    public void urutkanLaguBerdasarkanDurasi() {
        if (jumlahLagu == 0) {
            System.out.println("Playlist masih kosong, tidak ada yang bisa diurutkan.");
            return;
        }

        System.out.println("Sebelum diurutkan:");
        tampilkanSemuaLagu();

        // Bubble Sort ascending berdasarkan durasi
        for (int i = 0; i < jumlahLagu - 1; i++) {
            for (int j = 0; j < jumlahLagu - 1 - i; j++) {
                if (playlist[j].getDurasi() > playlist[j + 1].getDurasi()) {
                    Lagu temp = playlist[j];
                    playlist[j] = playlist[j + 1];
                    playlist[j + 1] = temp;
                }
            }
        }

        System.out.println("\nSesudah diurutkan (berdasarkan durasi, ascending):");
        tampilkanSemuaLagu();
    }

    // Method main: Menu Interaktif4
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlaylistArray playlistArray = new PlaylistArray();

        // Data awal sebagai contoh (opsional, sesuai contoh output pada soal)
        playlistArray.playlist[0] = new Lagu("Perfect", "Ed Sheeran", 4.23);
        playlistArray.playlist[1] = new Lagu("Shivers", "Ed Sheeran", 3.50);
        playlistArray.playlist[2] = new Lagu("As It Was", "Harry Styles", 3.39);
        playlistArray.playlist[3] = new Lagu("Ghost", "Justin Bieber", 2.33);
        playlistArray.playlist[4] = new Lagu("Stay", "The Kid LAROI & Justin Bieber", 2.21);    
        playlistArray.jumlahLagu = 5;

        int pilihan;
        do {
            System.out.println("\n=== MENU PLAYLIST MUSIK ===");
            System.out.println("1. Tampilkan semua lagu");
            System.out.println("2. Tambah lagu baru");
            System.out.println("3. Hapus lagu berdasarkan judul");
            System.out.println("4. Cari lagu berdasarkan judul");
            System.out.println("5. Urutkan berdasarkan durasi");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");

            pilihan = Integer.parseInt(scanner.nextLine());

            switch (pilihan) {
                case 1:
                    playlistArray.tampilkanSemuaLagu();
                    break;
                case 2:
                    playlistArray.tambahLagu(scanner);
                    System.out.println("Lagu berhasil ditambahkan!");
                    break;
                case 3:
                    playlistArray.hapusLagu(scanner);
                    System.out.println("Lagu berhasil dihapus!");
                    break;
                case 4:
                    playlistArray.cariLagu(scanner);
                    break;
                case 5:
                    playlistArray.urutkanLaguBerdasarkanDurasi();
                    System.out.println("Lagu berhasil diurutkan!");
                    break;
                case 6:
                    System.out.println("Terima kasih telah menggunakan program ini!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        } while (pilihan != 6);

        scanner.close();
    }
}
