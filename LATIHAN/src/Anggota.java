class Anggota {
    String idAnggota;
    String nama;
    String tipe;

    public Anggota(String idAnggota, String nama, String tipe) {
        this.idAnggota = idAnggota;
        this.nama = nama;
        this.tipe = tipe;
    }

    public String getIdAnggota() {
        return idAnggota;
    }

    public String getNama() {
        return nama;
    }

    public String getTipe() {
        return tipe;
    }

    @Override
    public String toString() {
        return "ID: " + idAnggota + " | " + "Nama: " + nama + " | " + "Tipe: " + tipe;
    }
}