package id.sch.smktelkom_mlg.privateassignment.xirpl206.tvshowlist;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import id.sch.smktelkom_mlg.privateassignment.xirpl206.tvshowlist.adapter.AiringShowAdapter;
import id.sch.smktelkom_mlg.privateassignment.xirpl206.tvshowlist.adapter.PopularShowAdapter;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AiringShowAdapter.IComingSoonAdapter, PopularShowAdapter.ISourceAdapter {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        changePage(R.id.nav_today);
        navigationView.setCheckedItem(R.id.nav_today);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        changePage(id);

        return true;
    }

    private void changePage(int id) {
        Fragment fragment = null;

        if (id == R.id.nav_today) {
            fragment = new TodayFragment();
            setTitle("Airing Today TV Show");
        } else if (id == R.id.nav_airing) {
            fragment = new AiringFragment();
            setTitle("Now Airing TV Show");
        } else if (id == R.id.nav_popular) {
            fragment = new PopularFragment();
            setTitle("Popular TV Show");
        } else if (id == R.id.nav_about) {
            fragment = new AboutFragment();
            setTitle("About Us");
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment).commitNow();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public void showArticles(String title, String overview, String backdrop_path) {

    }
}
