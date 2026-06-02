public class App {
    public static void main(String[] args) {
        System.out.println("=== SISTEM MANAJEMEN GUDANG ===");
        SistemGudang gudang = new SistemGudang();
        //Mendaftarkan 3 barang baru 
        gudang.tambahBarangBaru("B01", "Keyboard Mechanical", "Elektronik", 15);
        gudang.tambahBarangBaru("B02", "Kursi ", "Furnitur", 5);
        gudang.tambahBarangBaru("B03", "Monitor 30 Inch", "Elektronik", 10);
        gudang.tambahBarangBaru("B03", "Laptop Macbook", "Elektronik", 10);
        //Melakukan satu kali penambahan Stok 
        gudang.tambahStok("B01", 5);
        //Melakukan satu kali pengurangan Stok
        gudang.kurangiStok("B02", 2);
        //Melakukan 1 kali pengurangan stok yang gagal karena stok ditarik lebih besar dari sisa
        gudang.kurangiStok("B03", 20);
        //Memanggil metode cetak laporan akhir
        gudang.cetakLaporan();
    }
}