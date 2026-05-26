import java.util.*;

public class App {
    public static void main(String[] args) {

        // 1. MAP: Menyimpan daftar film
        Map<String, Film> daftarFilm = new HashMap<String, Film>();

        daftarFilm.put("F01", new Film("Naruto Shippuden", 80000));
        daftarFilm.put("F02", new Film("One Piece", 75000));
        daftarFilm.put("F03", new Film("Dragon Ball Z", 90000));

        // Menyimpan nomor kursi yang sudah dipilih
        Set<String> nomorKursiyangSudahDipilih = new HashSet<String>();

        // Menyimpan daftar pemesanan simulasi
        List<Pemesanan> daftarPemesanan = new ArrayList<Pemesanan>();

        // Menyimpan riwayat transaksi yang berhasil
        List<Pemesanan> riwayatTransaksi = new ArrayList<Pemesanan>();

        // Kasir memilih film berdasarkan kode film
        String kodeFilm = "F01";

        // Mengambil objek film dari Map menggunakan kode film
        Film filmDipilih = daftarFilm.get(kodeFilm);

        // Jika kode film valid, masukkan data pemesanan
        if (filmDipilih != null) {
            daftarPemesanan.add(new Pemesanan("Rendi", filmDipilih, "A1"));
            daftarPemesanan.add(new Pemesanan("Budi", filmDipilih, "A2"));
            daftarPemesanan.add(new Pemesanan("Siti", filmDipilih, "B1"));
            daftarPemesanan.add(new Pemesanan("Doni", filmDipilih, "A1"));
        } else {
            System.out.println("Kode film tidak ditemukan.");
        }

        // Memproses setiap pemesanan
        for (Pemesanan pemesanan : daftarPemesanan) {

            boolean statusKursi = nomorKursiyangSudahDipilih.add(pemesanan.getNomorKursi());

            if (statusKursi == true) {
                riwayatTransaksi.add(pemesanan);
                System.out.println("Pemesanan " + pemesanan.getNamaPemesan() + " berhasil.");
            } else {
                System.out.println(
                        "Pemesanan " + pemesanan.getNamaPemesan()
                        + " gagal, kursi " + pemesanan.getNomorKursi()
                        + " sudah dipilih."
                );
            }
        }

        // Menampilkan riwayat transaksi berhasil
        System.out.println("\n=== RIWAYAT TRANSAKSI BERHASIL ===");

        for (Pemesanan pemesanan : riwayatTransaksi) {
            pemesanan.tampilkanPemesanan();
            System.out.println("-----------------------------");
        }
    }
}