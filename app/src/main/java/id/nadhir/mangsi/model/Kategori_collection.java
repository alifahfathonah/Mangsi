package id.nadhir.mangsi.model;

import java.util.ArrayList;

import id.nadhir.mangsi.R;

/**
 * Created by nadhir on 12/25/17.
 */

public class Kategori_collection {
    public static ArrayList<Kategori> getKategori()
    {
        ArrayList<Kategori> kategoriArrayList=new ArrayList<>();
        Kategori s=new Kategori("Dokumen",R.drawable.ic_dokumen);
        s.setNama("Dokumen");
        s.setGambar(R.drawable.ic_dokumen);
        kategoriArrayList.add(s);
        s=new Kategori("Kartu Nama", R.drawable.ic_kartu_nama);
        kategoriArrayList.add(s);
        s=new Kategori("Banner", R.drawable.ic_banner);
        kategoriArrayList.add(s);
        s=new Kategori("Undangan", R.drawable.ic_undangan);
        kategoriArrayList.add(s);
        s=new Kategori("Foto", R.drawable.ic_foto);
        kategoriArrayList.add(s);
        s=new Kategori("Merchandise", R.drawable.ic_merchandise);
        kategoriArrayList.add(s);

        return kategoriArrayList;
    }
}
