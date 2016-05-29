package com.example.hikaro.kolesakz;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ListView listView;

    private ArrayAdapter<Spanned> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        JsonGet newsRequest = new JsonGet();
        ArrayList<NewsClass> news = newsRequest.getTwentyNewsfromAll();
        listView = (ListView) findViewById(R.id.listView_main);
        Spanned[] taggedNews = new Spanned[news.size()];
        for(int i = 0 ; i < news.size(); i++) {
            taggedNews[i] = Html.fromHtml(news.get(i).toString());
        }
        mAdapter = new ArrayAdapter<>(this,
                R.layout.list_item, taggedNews);

        listView.setAdapter(mAdapter);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here
        int id = item.getItemId();
        if (id == R.id.nav_all) {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_politics) {
            Intent intent = new Intent(MainActivity.this, Politics.class);
            startActivity(intent);
        } else if (id == R.id.nav_world) {
            Intent intent = new Intent(MainActivity.this, World.class);
            startActivity(intent);
        } else if (id == R.id.nav_society) {
            Intent intent = new Intent(MainActivity.this, Society.class);
            startActivity(intent);
        } else if (id == R.id.nav_economics) {
            Intent intent = new Intent(MainActivity.this, Economics.class);
            startActivity(intent);
        } else if (id == R.id.nav_sports) {
            Intent intent = new Intent(MainActivity.this, Sports.class);
            startActivity(intent);
        } else if (id == R.id.nav_accidents) {
            Intent intent = new Intent(MainActivity.this, Accidents.class);
            startActivity(intent);
        } else if (id == R.id.nav_culture) {
            Intent intent = new Intent(MainActivity.this, Culture.class);
            startActivity(intent);
        } else if (id == R.id.nav_science) {
            Intent intent = new Intent(MainActivity.this, Science.class);
            startActivity(intent);
        } else if (id == R.id.nav_health) {
            Intent intent = new Intent(MainActivity.this, Health.class);
            startActivity(intent);
        } else if (id == R.id.nav_technology) {
            Intent intent = new Intent(MainActivity.this, Technology.class);
            startActivity(intent);
        } else if (id == R.id.nav_internet) {
            Intent intent = new Intent(MainActivity.this, Internet.class);
            startActivity(intent);
        } else if (id == R.id.nav_auto) {
            Intent intent = new Intent(MainActivity.this, Auto.class);
            startActivity(intent);
        } else if (id == R.id.nav_tourizm) {
            Intent intent = new Intent(MainActivity.this, Tourism.class);
            startActivity(intent);
        } else if (id == R.id.nav_kazakh) {
            Intent intent = new Intent(MainActivity.this, Kazakh.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
