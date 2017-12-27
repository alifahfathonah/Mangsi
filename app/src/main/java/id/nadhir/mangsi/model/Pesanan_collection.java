package id.nadhir.mangsi.model;

import java.util.ArrayList;

import id.nadhir.mangsi.R;

/**
 * Created by nadhir on 12/25/17.
 */

public class Pesanan_collection {
    public static ArrayList<Pesanan> getPesanan() {
        ArrayList<Pesanan> pesananArrayList = new ArrayList<>();
        Pesanan s = new Pesanan("Ode Print", "File_print.docx",
                "Print", "Transfer", 10500);
        pesananArrayList.add(s);
        s = new Pesanan("Betah Print", "Praktikum.pdf",
                "Menunggu Konfirmasi", "-", 10);
        pesananArrayList.add(s);
        return pesananArrayList;
    }

}
