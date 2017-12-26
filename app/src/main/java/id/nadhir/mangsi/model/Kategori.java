package id.nadhir.mangsi.model;

/**
 * Created by nadhir on 12/26/17.
 */

public class Kategori {
    private String nama;
    private int gambar;

    public Kategori() {

    }

    public Kategori(String nama, int gambar) {
        this.nama = nama;
        this.gambar = gambar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }
}
