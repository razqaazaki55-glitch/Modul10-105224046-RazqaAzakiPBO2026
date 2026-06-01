import java.util.ArrayList; //menyimpan riwayat aktivitas gudang
import java.util.HashMap; //menyimpan data barang berdasarkan ID barang
import java.util.HashSet; //menyimpan kategori unik untuk menghindari kategori yang sama 
import java.util.List; //daftar data barang
import java.util.Map; //menyimpan key dan value 
import java.util.Set; //meyimpan data yang unik 

public class SistemGudang {
    private Map<String, Barang> databaseBarang; //menyimpan data barang dengan ID sebagai key
    private Set<String> kategoriUnik; //menyimpan kategori unik
    private List<String> riwayat; //mencatat semua aktivitas yang ada di gudang
    //Constructor
    public SistemGudang() {
        this.databaseBarang = new HashMap<>();
        this.kategoriUnik = new HashSet<>();
        this.riwayat = new ArrayList<>();
    }
    //Methode untuk menambahkan barang baru ke dalam sistem gudang
    public void tambahBarangBaru(String id, String nama, String kategori, int stok) {
        //Mengecek apakah ID barang belum terdafatar di sistem
        if (!databaseBarang.containsKey(id)) {
            //Membuat data barang baru dari parameter yang diberikan
            Barang barangBaru = new Barang(id, nama, kategori, stok);
            databaseBarang.put(id, barangBaru); //menyimpan barang baru menggunakan ID sebagai key
            kategoriUnik.add(kategori); //menyimpan kategor barang 
            riwayat.add("Barang Masuk: " + id + " (" + nama + ") didaftarkan dengan " + stok + " unit."); //mencatat aktivitas ke dalam riwayat 
        } else {    
            riwayat.add("Gagal: ID Barang " + id + " sudah terdaftar di sistem."); //Jika terdapat ID yang sama, maka barang tidak bisa didaftarkan kembali
        }
    }
    //method untuk menambah stok barang yang sudah ada
    public void tambahStok(String id, int jumlah) {
        //mengecek apakah barang dengan ID tersebut ada di sistem
        if (databaseBarang.containsKey(id)) {
            Barang barang = databaseBarang.get(id); //mengambilkan data barang berdasarkan ID
            barang.setStok(barang.getStok() + jumlah); //menambahkan jumlah stok yang lama dengan jumlah stok yang baru masuk 
            riwayat.add("Update Stok: " + id + " ditambah " + jumlah + " unit. (Total sekarang: " + barang.getStok() + ")"); //mencatat aktivitas penambahan stok ke dalam riwayat
        } else {
            riwayat.add("Gagal: ID Barang " + id + " tidak ditemukan saat tambah stok."); //jika ID tidak ditemukan, proses tambah stok tidak dilakukan
        }
    }
    //method untuk mengurangi stok barang
    public void kurangiStok(String id, int jumlah) {
        //mengecek dulu apakah barangnya ada di databaseBarang
        if (databaseBarang.containsKey(id)) {
            Barang barang = databaseBarang.get(id); //mengambil data barang yang ingin dikurangi stoknya 
            //stok hanya boleh dikurangi jika jumlahnya masih mencukupi
            if (barang.getStok() >= jumlah) {
                barang.setStok(barang.getStok() - jumlah); // mengurangi stok barang 
                riwayat.add("Barang Keluar: " + id + " ditarik " + jumlah + " unit. (Sisa: " + barang.getStok() + ")"); //mencatat aktivitas barang yang keluar 
            } else {
                riwayat.add("Gagal Tarik: Stok " + id + " tidak mencukupi! (Diminta: " + jumlah + ", Sisa: " + barang.getStok() + ")"); //jika stok kurang, transaksi tidak bisa dilakukan
            }
        } else {
            riwayat.add("Gagal Tarik: ID Barang " + id + " tidak ditemukan."); //jika ID tidak ada, sistem tidak bisa memproses pengurangan stok
        }
    }
    //method untuk menampilkan laporan akhir gudang
    public void cetakLaporan() {
        System.out.println("\nLAPORAN SISTEM GUDANG ");
        //menampilkan semua kategori yang ada di gudang
        System.out.println("\nKATEGORI TERSEDIA");
        for (String kategori : kategoriUnik) { 
            System.out.println("- " + kategori); 
        }
        //menampilkan daftar barang beserta sisa stoknya
        System.out.println("\nSISA STOK BARANG");
        for (Barang barang : databaseBarang.values()) {
            System.out.println("- [" + barang.getIdBarang() + "] " + barang.getNamaBarang() + " | Kategori: " + barang.getKategori() + " | Sisa: " + barang.getStok() + " unit");
        }
        //menampilkan semua aktivitas yang sudah tercatat
        System.out.println("\nRIWAYAT AKTIVITAS");
        for (int i = 0; i < riwayat.size(); i++) { 
            System.out.println((i + 1) + ". " + riwayat.get(i)); 
        }
        System.out.println("===========================================\n");
    }
}