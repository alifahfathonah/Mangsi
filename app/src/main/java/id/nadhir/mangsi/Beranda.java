package id.nadhir.mangsi;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import id.nadhir.mangsi.fragment.beranda;
import id.nadhir.mangsi.fragment.beranda_baru;
import id.nadhir.mangsi.fragment.beranda_populer;
import id.nadhir.mangsi.fragment.kategori;
import id.nadhir.mangsi.fragment.pesanan;
import id.nadhir.mangsi.helper.BottomNavigationViewHelper;

import static android.content.ContentValues.TAG;

public class Beranda extends AppCompatActivity
                     implements beranda.OnFragmentInteractionListener,
                                beranda_populer.OnFragmentInteractionListener,
                                beranda_baru.OnFragmentInteractionListener,
        kategori.OnFragmentInteractionListener,
        pesanan.OnFragmentInteractionListener, View.OnClickListener, View.OnTouchListener {


    private TextView mTextMessage;
    private TextView tv_notificationCount;
    private ImageButton ib_actionbar_notification;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_beranda:
                    Log.d(TAG, "onNavigationItemSelected: Beranda Fragment Load");
                    changeFragment(0);
                    return true;
                case R.id.navigation_kategori:
                    Log.d(TAG, "onNavigationItemSelected: Kategori Fragment Load");
                    changeFragment(1);
                    return true;
                case R.id.navigation_pesanan:
                    Log.d(TAG, "onNavigationItemSelected: Pesanan Fragment Load");
                    changeFragment(2);
                    return true;
                case R.id.navigation_profile:
                    //Toast.makeText(Beranda.this, "Profile", Toast.LENGTH_SHORT).show();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);

        //defaultnya pas pertama buka beranda
        changeFragment(0);

        setActionBar();
        //disable shifting animation with helper
        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }
    private void changeFragment(int position) {

        Fragment newFragment = null;

        if (position == 0) {
            setActionBar();
            newFragment = beranda.newInstance("Helo","World");
        } else if (position == 1) {
            newFragment = new kategori();
        } else if (position == 2) {
            newFragment = new pesanan();
        }

        getSupportFragmentManager().beginTransaction().replace(
                R.id.fragmentContainer, newFragment)
                .commit();
    }

    private void setActionBar() {
        // Inflate your custom layout
        final ViewGroup actionBarLayout = (ViewGroup) getLayoutInflater().inflate(
                R.layout.action_bar_beranda,
                null);

        // Set up your ActionBar
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setCustomView(actionBarLayout);

            //set padding biar mepet
            Toolbar parent = (Toolbar) actionBarLayout.getParent();
            parent.setPadding(0, 0, 0, 0);//for tab otherwise give space in tab
            parent.setContentInsetsAbsolute(0, 0);

            //ketika di click search akan intent ke activity search
            View viewActionbar = actionBar.getCustomView();
            EditText searchButton = viewActionbar.findViewById(R.id.et_actionbar_search);
            searchButton.setOnTouchListener(this);

            ib_actionbar_notification = viewActionbar.findViewById(R.id.ib_actionbar_notification);
            ib_actionbar_notification.setOnClickListener(this);
            tv_notificationCount = viewActionbar.findViewById(R.id.tv_actionbar_notificationCount);

            // You customization
            final int actionBarColor = getResources().getColor(R.color.action_bar);
            actionBar.setBackgroundDrawable(new ColorDrawable(actionBarColor));
        } else {
            Log.d(TAG, "setActionBar: ActionBar Null");
        }

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    private boolean status = false;
    int coba = 1;
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
            default:
                break;
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (view.getId()) {
            case R.id.et_actionbar_search: {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    Log.d(TAG, "onTouch: Search launch bruh");
                    //action ketika di klik search buttonImage
                    Intent intent = new Intent(this, Search.class);
                    startActivity(intent);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    return true;
                }
            }
            default:
                return false;
        }
    }
}
