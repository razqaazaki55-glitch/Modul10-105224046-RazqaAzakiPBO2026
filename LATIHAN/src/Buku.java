class Buku {
   String isbn;
   String judul;

    public Buku(String isbn, String judul){
        this.isbn = isbn;
        this.judul = judul;
    }

    public String getJudul() {
        return judul;
    }

    public String getIsbn() {
        return isbn;
    }
}