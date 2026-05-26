class Pemesanan {
    String namaPemesan;
    Film judulFilm;
    String nomorKursi;

    public Pemesanan(String namaPemesan, Film judulFilm, String nomorKursi){
        this.namaPemesan = namaPemesan;
        this.judulFilm = judulFilm;
        this.nomorKursi = nomorKursi;
    }

    public String getNamaPemesan(){
        return namaPemesan;
    }

    public Film getJudulFilm(){
        return judulFilm;
    }

    public String getNomorKursi(){
        return nomorKursi;
    }

    public void tampilkanPemesanan(){
        System.out.println("Nama Pemesan: " + namaPemesan);
        System.out.println("Judul Film: " + judulFilm.getJudul());
        System.out.println("Nomor Kursi: " + nomorKursi);
        System.out.println("Harga: " + judulFilm.getHarga());
    }
}
