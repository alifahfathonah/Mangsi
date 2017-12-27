package id.nadhir.mangsi;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.telecom.Call;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Search extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private String TAG = "TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //di inflate dulu menu nya baru panggil menu item
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        searchItem.expandActionView(); //biar langsung nulis di form
        MenuItemCompat.setOnActionExpandListener(searchItem, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                return false;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                //biar ketika di klik back (collapse) langsung close activity
                finish();
                return false;
            }
        });

        SearchView searchView = (SearchView) searchItem.getActionView();
        if (searchView != null) {
            searchView.setIconifiedByDefault(true);
            searchView.requestFocus();
            searchView.setOnQueryTextListener(this);
            searchView.setQueryHint("Search");
            searchView.setSubmitButtonEnabled(true);
            searchView.setBackgroundResource(R.drawable.search_background);
            EditText editText = searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
            editText.setHintTextColor(getResources().getColor(R.color.colorGray));
            editText.setTextColor(getResources().getColor(R.color.black));
            ImageView searchIconView = searchView.findViewById(android.support.v7.appcompat.R.id.search_go_btn);
            searchIconView.setImageResource(R.drawable.ic_search);
            ImageView searchCancelView = searchView.findViewById(android.support.v7.appcompat.R.id.search_close_btn);
            searchCancelView.setColorFilter(R.color.colorGray);
        } else {
            Log.d(TAG, "onCreateOptionsMenu: searchView Object null");
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void finish() {
        super.finish();
        this.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
