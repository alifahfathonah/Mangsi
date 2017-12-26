package id.nadhir.mangsi.adapter;

/**
 * Created by nadhir on 12/25/17.
 */

import android.widget.ImageView;

import id.nadhir.mangsi.R;
import id.nadhir.mangsi.model.Kategori;
import id.nadhir.mangsi.model.percetakan;

import android.content.Context;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
import android.widget.TextView;

import com.iarcuschin.simpleratingbar.SimpleRatingBar;

import java.util.ArrayList;

public class RecyclerAdapterBeranda extends RecyclerView.Adapter<RecyclerAdapterBeranda.MyHolder> {
    private ArrayList<percetakan> spaceships;
    private Context c;
    public RecyclerAdapterBeranda(Context c, ArrayList<percetakan> spaceships) {
        this.spaceships = spaceships;
        this.c = c;
    }
    /*
    INITIALIZE VIEWHOLDER
     */
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.fragment_beranda_item,parent,false);
        return new MyHolder(v);
    }
    /*
    BIND
     */
    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        percetakan s=spaceships.get(position);
        holder.nameTxt.setText(s.getName());
        holder.img.setImageResource(s.getImage());
        holder.ratingBar.setRating(s.getRating());
    }
    /*
    TOTAL SPACECRAFTS NUM
     */
    @Override
    public int getItemCount() {
        return spaceships.size();
    }
    /*
    VIEW HOLDER CLASS
     */
    class MyHolder extends RecyclerView.ViewHolder
    {
        TextView nameTxt;
        ImageView img;
        SimpleRatingBar ratingBar;
        public MyHolder(View itemView) {
            super(itemView);
            nameTxt= (TextView) itemView.findViewById(R.id.nameTxt);
            img= (ImageView) itemView.findViewById(R.id.spacecraftImage);
            ratingBar= (SimpleRatingBar) itemView.findViewById(R.id.ratingBarID);
        }
    }
}
