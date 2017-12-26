package id.nadhir.mangsi.model;

import java.util.ArrayList;

import id.nadhir.mangsi.R;

/**
 * Created by nadhir on 12/25/17.
 */

public class percetakan_collection {
    public static ArrayList<percetakan> getSpaceships()
    {
        ArrayList<percetakan> spaceships=new ArrayList<>();
        percetakan s=new percetakan();
        s.setName("Spitzer");
        s.setRating(4);
        s.setImage(R.drawable.ic_menu_kategori);
        spaceships.add(s);
        s=new percetakan();
        s.setName("Enterpise");
        s.setRating(3);
        s.setImage(R.drawable.ic_home_black_24dp);
        spaceships.add(s);
        s=new percetakan();
        s.setName("Voyager");
        s.setRating(5);
        s.setImage(R.drawable.ic_menu_kategori);
        spaceships.add(s);
        s=new percetakan();
        s.setName("Opportunity");
        s.setRating(3);
        s.setImage(R.drawable.ic_menu_beranda);
        spaceships.add(s);
        s=new percetakan();
        s.setName("Pioneer");
        s.setRating(2);
        s.setImage(R.drawable.ic_menu_kategori_aktif);
        spaceships.add(s);
        s=new percetakan();
        s.setName("WMAP");
        s.setRating(4);
        s.setImage(R.drawable.ic_menu_keranjang);
        spaceships.add(s);
        s=new percetakan();
        s.setName("Rosetter");
        s.setRating(1);
        s.setImage(R.drawable.ic_menu_beranda_aktif);
        spaceships.add(s);
        s=new percetakan();
        s.setName("Hubble");
        s.setRating(5);
        s.setImage(R.drawable.ic_menu_keranjang);
        spaceships.add(s);
        return spaceships;
    }
    public static ArrayList<percetakan> getSpaceships2()
    {
        ArrayList<percetakan> spaceships=new ArrayList<>();
        percetakan s=new percetakan();
        s.setName("Enterpise");
        s.setRating(3);
        s.setImage(R.drawable.ic_home_black_24dp);
        spaceships.add(s);
        s=new percetakan();
        s.setName("Opportunity");
        s.setRating(3);
        s.setImage(R.drawable.ic_menu_beranda);
        spaceships.add(s);
        s=new percetakan();
        s.setName("Pioneer");
        s.setRating(2);
        s.setImage(R.drawable.ic_menu_kategori_aktif);
        spaceships.add(s);
        s=new percetakan();
        s.setName("WMAP");
        s.setRating(4);
        s.setImage(R.drawable.ic_menu_keranjang);
        spaceships.add(s);
        s=new percetakan();
        s.setName("Rosetter");
        s.setRating(1);
        s.setImage(R.drawable.ic_menu_beranda_aktif);
        spaceships.add(s);
        s=new percetakan();
        s.setName("Hubble");
        s.setRating(5);
        s.setImage(R.drawable.ic_menu_keranjang);
        spaceships.add(s);
        return spaceships;
    }
}
