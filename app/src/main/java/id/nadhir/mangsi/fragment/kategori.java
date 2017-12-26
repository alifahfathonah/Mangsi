package id.nadhir.mangsi.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import id.nadhir.mangsi.R;
import id.nadhir.mangsi.adapter.RecyclerAdapterBeranda;
import id.nadhir.mangsi.adapter.RecyclerAdapterKategori;
import id.nadhir.mangsi.adapter.SliderPagerAdapterBeranda;
import id.nadhir.mangsi.model.Kategori_collection;
import id.nadhir.mangsi.model.percetakan_collection;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link kategori.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link kategori#newInstance} factory method to
 * create an instance of this fragment.
 */
public class kategori extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ViewPager vp_slider;
    private LinearLayout ll_dots;
    private Context context;
    private Resources resources;
    SliderPagerAdapterBeranda sliderPagerAdapterBeranda = null;
    ArrayList<String> slider_image_list;
    private TextView[] dots;
    int page_position = 0;
    private OnFragmentInteractionListener mListener;

    public kategori() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment beranda.
     */
    // TODO: Rename and change types and number of parameters
    public static kategori newInstance(String param1, String param2) {
        kategori fragment = new kategori();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this.getContext();
        resources = this.getResources();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_kategori, container, false);

        RecyclerView rv= (RecyclerView) view.findViewById(R.id.rv_kategori);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(),2) {
            @Override
            public boolean canScrollVertically() {
                //disable / enable scrolling RecyclerView
                return true;
            }
        };
        rv.setLayoutManager(gridLayoutManager);
        rv.setAdapter(new RecyclerAdapterKategori(this.getContext(), Kategori_collection.getKategori()));

        // Set up your ActionBar
        final ActionBar actionBar = ((AppCompatActivity) this.getActivity()).getSupportActionBar();
        if (actionBar != null) {
            //set padding biar mepet
            Toolbar parent =(Toolbar) actionBar.getCustomView().getParent();
            parent.setPadding(25,0,15,0);//for tab otherwise give space in tab
            parent.setContentInsetsAbsolute(0,0);

            actionBar.setTitle("Kategori");
            actionBar.setIcon(R.drawable.ic_menubar_kategori);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setDisplayShowCustomEnabled(false);
        } else {
            Toast.makeText(context, "Null actionbar", Toast.LENGTH_SHORT).show();
        }


        // Inflate the layout for this fragment
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
