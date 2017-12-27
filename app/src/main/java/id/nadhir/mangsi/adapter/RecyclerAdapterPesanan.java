package id.nadhir.mangsi.adapter;

/**
 * Created by nadhir on 12/25/17.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.nadhir.mangsi.R;
import id.nadhir.mangsi.model.Kategori;
import id.nadhir.mangsi.model.Pesanan;

public class RecyclerAdapterPesanan extends RecyclerView.Adapter<RecyclerAdapterPesanan.MyHolder> {
    private ArrayList<Pesanan> pesananArrayList;
    private Context c;

    public RecyclerAdapterPesanan(Context c, ArrayList<Pesanan> pesananArrayList) {
        this.pesananArrayList = pesananArrayList;
        this.c = c;
    }

    /*
    INITIALIZE VIEWHOLDER
     */
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.fragment_pesanan_item, parent, false);
        return new MyHolder(v);
    }

    /*
    BIND
     */
    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        Pesanan s = pesananArrayList.get(position);
        holder.tempatPrint.setText(s.getTempat_print());
        holder.berkas.setText(s.getBerkas());
        holder.status.setText(s.getStatus());
        holder.harga.setText("Rp " + Integer.toString(s.getHarga()));
        holder.pembayaran.setText(s.getPembayaran());
        holder.img.setImageResource(
                (s.getStatus().toLowerCase().equals("print") ?
                        R.drawable.ic_pesanan_status_1 :
                        R.drawable.ic_pesanan_status_2));
    }

    /*
    TOTAL SPACECRAFTS NUM
     */
    @Override
    public int getItemCount() {
        return pesananArrayList.size();
    }

    /*
    VIEW HOLDER CLASS
     */
    class MyHolder extends RecyclerView.ViewHolder {
        TextView tempatPrint, berkas, status, harga, pembayaran;
        ImageView img;

        public MyHolder(View itemView) {
            super(itemView);
            tempatPrint = itemView.findViewById(R.id.tv_pesanan_isi_tempat_print);
            berkas = itemView.findViewById(R.id.tv_pesanan_isi_berkas);
            status = itemView.findViewById(R.id.tv_pesanan_isi_status);
            harga = itemView.findViewById(R.id.tv_pesanan_isi_harga);
            pembayaran = itemView.findViewById(R.id.tv_pesanan_isi_pembayaran);
            img = itemView.findViewById(R.id.iv_pesanan_item);
        }
    }
}
