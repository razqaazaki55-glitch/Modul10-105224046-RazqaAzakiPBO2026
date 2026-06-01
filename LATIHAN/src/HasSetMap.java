import java.util.*;

public class HasSetMap {
    public static void main(String[] args) {
        //Soal 1
        Map<String, Buku> katalogBuku = new HashMap<>();

        Buku buku1 = new Buku("B001", "Pemrograman Java");
        Buku buku2 = new Buku("B002", "Struktur Data");
        Buku buku3 = new Buku("B003", "Basis Data");
        
        katalogBuku.put(buku1.getIsbn(), buku1);
        katalogBuku.put(buku2.getIsbn(), buku2);
        katalogBuku.put(buku3.getIsbn(), buku3);

        System.out.println("=== DAFTAR BUKU ===");
        for (Buku buku : katalogBuku.values()) {
            System.out.println(buku);
        }

        System.out.println();

        // Mencari buku berdasarkan ISBN
        String isbnDicari = "B002";
        Buku bukuDicari = katalogBuku.get(isbnDicari);

        System.out.println("=== PENCARIAN BUKU ===");
        if (bukuDicari != null) {
            System.out.println("Buku ditemukan: " + bukuDicari);
        } else {
            System.out.println("Buku dengan ISBN " + isbnDicari + " tidak ditemukan.");
        }

        System.out.println();

        //Soal 2
        Set<Anggota> daftarAnggota = new HashSet<>();

        Anggota anggota1 = new Anggota("A001", "Razqa", "Mahasiswa");
        Anggota anggota2 = new Anggota("A002", "Yosafat", "Dosen");
        Anggota anggota3 = new Anggota("A003", "Pradana", "Mahasiswa");
        Anggota anggota4 = new Anggota("A001", "Razqa2", "Mahasiswa"); // Duplikat

        tambahAnggota(daftarAnggota, anggota1);
        tambahAnggota(daftarAnggota, anggota2);
        tambahAnggota(daftarAnggota, anggota3);
        tambahAnggota(daftarAnggota, anggota4);

        System.out.println();
        System.out.println("=== DAFTAR ANGGOTA ===");
        for (Anggota anggota : daftarAnggota) {
            System.out.println(anggota);
        }

        System.out.println();

        //SOAL 3
        Deque<Anggota> antreanPeminjaman = new LinkedList<>();

        masukAntrean(antreanPeminjaman, anggota1);
        masukAntrean(antreanPeminjaman, anggota2);
        masukAntrean(antreanPeminjaman, anggota3);

        System.out.println();
        System.out.println("=== ANTREAN PEMINJAMAN ===");
        for (Anggota anggota : antreanPeminjaman) {
            System.out.println(anggota);
        }
    }

    public static void tambahAnggota(Set<Anggota> daftarAnggota, Anggota anggota) {
        if (daftarAnggota.add(anggota)) {
            System.out.println("Anggota berhasil ditambahkan: " + anggota.getNama());
        } else {
            System.out.println("Anggota duplikat ditolak: " + anggota.getNama());
        }
    }

    public static void masukAntrean(Deque<Anggota> antrean, Anggota anggota) {
        if (anggota.getTipe().equalsIgnoreCase("Dosen")) {
            antrean.addFirst(anggota);
            System.out.println(anggota.getNama() + " adalah Dosen, masuk ke antrean paling depan.");
        } else {
            antrean.addLast(anggota);
            System.out.println(anggota.getNama() + " adalah Mahasiswa, masuk ke antrean paling belakang.");
        }
    }
}