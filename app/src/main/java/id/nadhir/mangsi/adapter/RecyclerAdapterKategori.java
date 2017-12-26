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

import com.iarcuschin.simpleratingbar.SimpleRatingBar;

import java.util.ArrayList;

import id.nadhir.mangsi.R;
import id.nadhir.mangsi.model.Kategori;

public class RecyclerAdapterKategori extends RecyclerView.Adapter<RecyclerAdapterKategori.MyHolder> {
    private ArrayList<Kategori> kategoriArrayList;
    private Context c;
    public RecyclerAdapterKategori(Context c, ArrayList<Kategori> kategoriArrayList) {
        this.kategoriArrayList = kategoriArrayList;
        this.c = c;
    }
    /*
    INITIALIZE VIEWHOLDER
     */
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.fragment_kategori_item,parent,false);
        return new MyHolder(v);
    }
    /*
    BIND
     */
    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        Kategori s= kategoriArrayList.get(position);
        holder.nameTxt.setText(s.getNama());
        holder.img.setImageResource(s.getGambar());
    }
    /*
    TOTAL SPACECRAFTS NUM
     */
    @Override
    public int getItemCount() {
        return kategoriArrayList.size();
    }
    /*
    VIEW HOLDER CLASS
     */
    class MyHolder extends RecyclerView.ViewHolder
    {
        TextView nameTxt;
        ImageView img;

        public MyHolder(View itemView) {
            super(itemView);
            nameTxt= (TextView) itemView.findViewById(R.id.tv_kategori);
            img= (ImageView) itemView.findViewById(R.id.iv_kategori);
        }
    }
}
