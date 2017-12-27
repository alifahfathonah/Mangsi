package id.nadhir.mangsi;

import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import id.nadhir.mangsi.fragment.beranda;
import id.nadhir.mangsi.fragment.beranda_baru;
import id.nadhir.mangsi.fragment.beranda_populer;
import id.nadhir.mangsi.fragment.kategori;
import id.nadhir.mangsi.fragment.pesanan;
import id.nadhir.mangsi.helper.BottomNavigationViewHelper;

public class Beranda extends AppCompatActivity
                     implements beranda.OnFragmentInteractionListener,
                                beranda_populer.OnFragmentInteractionListener,
                                beranda_baru.OnFragmentInteractionListener,
        kategori.OnFragmentInteractionListener,
        pesanan.OnFragmentInteractionListener
{


    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_beranda:
                    Toast.makeText(Beranda.this, "Beranda", Toast.LENGTH_SHORT).show();
                    changeFragment(0);
                    return true;
                case R.id.navigation_kategori:
                    Toast.makeText(Beranda.this, "Kategori", Toast.LENGTH_SHORT).show();
                    changeFragment(1);
                    return true;
                case R.id.navigation_pesanan:
                    changeFragment(2);
                    Toast.makeText(Beranda.this, "Pesanan", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_profile:
                    Toast.makeText(Beranda.this, "Profile", Toast.LENGTH_SHORT).show();
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

        //disable shifting animation with helper
        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }
    private void changeFragment(int position) {

        Fragment newFragment = null;

        if (position == 0) {
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

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
