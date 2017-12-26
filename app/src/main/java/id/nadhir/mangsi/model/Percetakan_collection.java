package id.nadhir.mangsi.model;

import java.util.ArrayList;

import id.nadhir.mangsi.R;

/**
 * Created by nadhir on 12/25/17.
 */

public class Percetakan_collection {
    public static ArrayList<Percetakan> getSpaceships()
    {
        ArrayList<Percetakan> spaceships = new ArrayList<>();
        Percetakan s = new Percetakan();
        s.setName("Spitzer");
        s.setRating(4);
        s.setImage(R.drawable.ic_menu_kategori);
        spaceships.add(s);
        s = new Percetakan();
        s.setName("Enterpise");
        s.setRating(3);
        s.setImage(R.drawable.ic_home_black_24dp);
        spaceships.add(s);
        s = new Percetakan();
        s.setName("Voyager");
        s.setRating(5);
        s.setImage(R.drawable.ic_menu_kategori);
        spaceships.add(s);
        s = new Percetakan();
        s.setName("Opportunity");
        s.setRating(3);
        s.setImage(R.drawable.ic_menu_beranda);
        spaceships.add(s);
        s = new Percetakan();
        s.setName("Pioneer");
        s.setRating(2);
        s.setImage(R.drawable.ic_menu_kategori_aktif);
        spaceships.add(s);
        s = new Percetakan();
        s.setName("WMAP");
        s.setRating(4);
        s.setImage(R.drawable.ic_menu_keranjang);
        spaceships.add(s);
        s = new Percetakan();
        s.setName("Rosetter");
        s.setRating(1);
        s.setImage(R.drawable.ic_menu_beranda_aktif);
        spaceships.add(s);
        s = new Percetakan();
        s.setName("Hubble");
        s.setRating(5);
        s.setImage(R.drawable.ic_menu_keranjang);
        spaceships.add(s);
        return spaceships;
    }

    public static ArrayList<Percetakan> getSpaceships2()
    {
        ArrayList<Percetakan> spaceships = new ArrayList<>();
        Percetakan s = new Percetakan();
        s.setName("Enterpise");
        s.setRating(3);
        s.setImage(R.drawable.ic_home_black_24dp);
        spaceships.add(s);
        s = new Percetakan();
        s.setName("Opportunity");
        s.setRating(3);
        s.setImage(R.drawable.ic_menu_beranda);
        spaceships.add(s);
        s = new Percetakan();
        s.setName("Pioneer");
        s.setRating(2);
        s.setImage(R.drawable.ic_menu_kategori_aktif);
        spaceships.add(s);
        s = new Percetakan();
        s.setName("WMAP");
        s.setRating(4);
        s.setImage(R.drawable.ic_menu_keranjang);
        spaceships.add(s);
        s = new Percetakan();
        s.setName("Rosetter");
        s.setRating(1);
        s.setImage(R.drawable.ic_menu_beranda_aktif);
        spaceships.add(s);
        s = new Percetakan();
        s.setName("Hubble");
        s.setRating(5);
        s.setImage(R.drawable.ic_menu_keranjang);
        spaceships.add(s);
        return spaceships;
    }
}
