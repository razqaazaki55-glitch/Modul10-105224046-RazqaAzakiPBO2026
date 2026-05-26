public class Film {
    String judulFilm;
    double harga;

    public Film(String judulFilm, double harga){
        this.judulFilm = judulFilm;
        this.harga = harga;
    }

    public String getJudul(){
        return judulFilm;
    }

    public double getHarga(){
        return harga;
    }
}
