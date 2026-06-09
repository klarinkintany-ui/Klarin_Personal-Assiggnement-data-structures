/**
 * Class Mahasiswa - merepresentasikan data seorang mahasiswa
 * Menerapkan konsep enkapsulasi OOP dengan atribut private dan method public
 */
public class Mahasiswa {

    // Atribut mahasiswa
    private String nama;
    private String nim;
    private String jurusan;
    private double ipk; // private untuk enkapsulasi

    /**
     * Constructor untuk menginisialisasi data mahasiswa
     * @param nama    Nama lengkap mahasiswa
     * @param nim     Nomor Induk Mahasiswa
     * @param jurusan Jurusan yang ditempuh
     * @param ipk     Indeks Prestasi Kumulatif
     */
    public Mahasiswa(String nama, String nim, String jurusan, double ipk) {
        this.nama    = nama;
        this.nim     = nim;
        this.jurusan = jurusan;
        this.ipk     = ipk;
    }

    // ===================== Getter & Setter =====================

    /** Getter untuk nama */
    public String getNama() { return nama; }

    /** Setter untuk nama */
    public void setNama(String nama) { this.nama = nama; }

    /** Getter untuk NIM */
    public String getNim() { return nim; }

    /** Setter untuk NIM */
    public void setNim(String nim) { this.nim = nim; }

    /** Getter untuk jurusan */
    public String getJurusan() { return jurusan; }

    /** Setter untuk jurusan */
    public void setJurusan(String jurusan) { this.jurusan = jurusan; }

    /** Getter untuk IPK */
    public double getIpk() { return ipk; }

    /** Setter untuk IPK */
    public void setIpk(double ipk) { this.ipk = ipk; }

    // ===================== Method Utama =====================

    /**
     * Menampilkan informasi lengkap mahasiswa ke konsol
     */
    public void tampilkanInfo() {
        System.out.println("Nama    : " + nama);
        System.out.println("NIM     : " + nim);
        System.out.println("Jurusan : " + jurusan);
        System.out.printf ("IPK     : %.2f%n", ipk);
    }

    /**
     * Mengecek status kelulusan mahasiswa berdasarkan IPK
     * IPK >= 3.00 -> Lulus | IPK < 3.00 -> Belum Lulus
     * @return String status kelulusan
     */
    public String cekKelulusan() {
        if (ipk >= 3.00) {
            return "Lulus";
        } else {
            return "Belum Lulus";
        }
    }

    /**
     * Memperbarui nilai IPK mahasiswa
     * @param ipkBaru Nilai IPK baru yang akan diset
     */
    public void updateIpk(double ipkBaru) {
        this.ipk = ipkBaru;
        System.out.println("Data berhasil diperbarui!");
    }

    /**
     * Menentukan predikat akademik mahasiswa berdasarkan nilai IPK:
     *   IPK >= 3.75           -> Dengan Pujian
     *   3.50 <= IPK < 3.75    -> Sangat Memuaskan
     *   3.00 <= IPK < 3.50    -> Memuaskan
     *   IPK < 3.00            -> Perlu Perbaikan
     * @return String predikat akademik
     */
    public String hitungPredikat() {
        if (ipk >= 3.75) {
            return "Dengan Pujian";
        } else if (ipk >= 3.50) {
            return "Sangat Memuaskan";
        } else if (ipk >= 3.00) {
            return "Memuaskan";
        } else {
            return "Perlu Perbaikan";
        }
    }
}
