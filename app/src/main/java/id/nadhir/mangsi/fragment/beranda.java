package id.nadhir.mangsi.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import id.nadhir.mangsi.Search;
import id.nadhir.mangsi.adapter.SliderPagerAdapterBeranda;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import id.nadhir.mangsi.R;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link beranda.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link beranda#newInstance} factory method to
 * create an instance of this fragment.
 */
public class beranda extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ViewPager vp_slider;
    private TextView tv_notificationCount;
    private LinearLayout ll_dots, ll_notification;
    private ImageButton searchButton, ib_actionbar_notification;
    private Context context;
    private Resources resources;
    SliderPagerAdapterBeranda sliderPagerAdapterBeranda = null;
    ArrayList<String> slider_image_list;
    private TextView[] dots;
    int page_position = 0;
    private OnFragmentInteractionListener mListener;

    public beranda() {
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
    public static beranda newInstance(String param1, String param2) {
        beranda fragment = new beranda();
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
        View view = inflater.inflate(R.layout.fragment_beranda, container, false);

        vp_slider = view.findViewById(R.id.vp_slider);
        ll_dots = view.findViewById(R.id.ll_dots);

        // method for initialisation
        setActionBar();
        init();

        // method for adding indicators
        addBottomDots(0);

        final Handler handler = new Handler();

        final Runnable update = new Runnable() {
            public void run() {
                if (page_position == slider_image_list.size()) {
                    page_position = 0;
                } else {
                    page_position = page_position + 1;
                }
                vp_slider.setCurrentItem(page_position, true);
            }
        };

        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(update);
            }
        }, 100, 5000);


        //menambahkan fragment beranda populer dan baru ke fragment beranda
        Fragment fragment_beranda_populer = new beranda_populer(),
                 fragment_beranda_baru = new beranda_baru();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.fl_fragment_beranda_populer, fragment_beranda_populer )
                   .add(R.id.fl_fragment_beranda_baru, fragment_beranda_baru)
                   .commit();

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

    private void setActionBar(){
        // Inflate your custom layout
        final ViewGroup actionBarLayout = (ViewGroup) getActivity().getLayoutInflater().inflate(
                R.layout.action_bar,
                null);

        // Set up your ActionBar
        final ActionBar actionBar = ((AppCompatActivity) this.getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setCustomView(actionBarLayout);

            //set padding biar mepet
            Toolbar parent =(Toolbar) actionBarLayout.getParent();
            parent.setPadding(0,0,0,0);//for tab otherwise give space in tab
            parent.setContentInsetsAbsolute(0,0);

            //ketika di click search akan intent ke activity search
            View viewActionbar = actionBar.getCustomView();
            searchButton = viewActionbar.findViewById(R.id.ib_actionbar_search);
            searchButton.setOnClickListener(this);
            ib_actionbar_notification = viewActionbar.findViewById(R.id.ib_actionbar_notification);
            ib_actionbar_notification.setOnClickListener(this);
            ll_notification = viewActionbar.findViewById(R.id.ll_notification);
            ll_notification.setOnClickListener(this);
            tv_notificationCount = viewActionbar.findViewById(R.id.tv_actionbar_notificationCount);

            // You customization
            final int actionBarColor = getResources().getColor(R.color.action_bar);
            actionBar.setBackgroundDrawable(new ColorDrawable(actionBarColor));
        } else {
            Log.d(TAG, "setActionBar: ActionBar Null");
        }

    }

    private void init() {

        slider_image_list = new ArrayList<>();

        //Add few items to slider_image_list ,this should contain url of images which should be displayed in slider
        // here i am adding few sample image links, you can add your own

        slider_image_list.add("http://images.all-free-download.com/images/graphiclarge/mountain_bongo_animal_mammal_220289.jpg");
        slider_image_list.add("http://images.all-free-download.com/images/graphiclarge/bird_mountain_bird_animal_226401.jpg");
        slider_image_list.add("http://images.all-free-download.com/images/graphiclarge/bird_mountain_bird_animal_226401.jpg");
        slider_image_list.add("http://images.all-free-download.com/images/graphiclarge/mountain_bongo_animal_mammal_220289.jpg");


        sliderPagerAdapterBeranda = new SliderPagerAdapterBeranda(getActivity(), slider_image_list);
        vp_slider.setAdapter(new SliderPagerAdapterBeranda(getActivity(), slider_image_list));

        vp_slider.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[slider_image_list.size()];

        ll_dots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(context);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(resources.getColor(R.color.white));
            ll_dots.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(resources.getColor(R.color.colorAccent));
    }

    boolean status = false;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_actionbar_notification: {
                //mecoba memberi action ketika di klik pada notifikasi
                Log.d(TAG, "onClick: Pressed bruh");
                if (status) {
                    tv_notificationCount.setVisibility(View.VISIBLE);
                    status = !status;
                } else {
                    tv_notificationCount.setVisibility(View.INVISIBLE);
                    status = !status;
                }
                break;
            }
            case R.id.ib_actionbar_search: {
                //action ketika di klik search buttonImage
                Intent intent = new Intent(getContext(), Search.class);
                startActivity(intent);
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            }
            default:
                break;
        }
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
