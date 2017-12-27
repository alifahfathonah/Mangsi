package id.nadhir.mangsi.model;

/**
 * Created by nadhir on 12/25/17.
 */

public class Pesanan {
    private String tempat_print,
            berkas, status, pembayaran;
    private int harga, gambar;

    public Pesanan() {
    }

    public Pesanan(String tempat_print, String berkas, String status, String pembayaran, int harga) {
        this.tempat_print = tempat_print;
        this.berkas = berkas;
        this.status = status;
        this.pembayaran = pembayaran;
        this.harga = harga;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public String getTempat_print() {
        return tempat_print;
    }

    public void setTempat_print(String tempat_print) {
        this.tempat_print = tempat_print;
    }

    public String getBerkas() {
        return berkas;
    }

    public void setBerkas(String berkas) {
        this.berkas = berkas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(String pembayaran) {
        this.pembayaran = pembayaran;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
