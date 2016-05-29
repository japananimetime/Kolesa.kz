package com.example.hikaro.kolesakz;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        ListView listView = (ListView)findViewById(R.id.listView);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
//                android.R.layout.activity_list_item, newsAsStrings);

//        listView.setAdapter(adapter);
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

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

        } else if (id == R.id.nav_politics) {
            Intent intent = new Intent(MainActivity.this, Politics.class);
            startActivity(intent);
        } else if (id == R.id.nav_world) {
            Intent intent = new Intent(MainActivity.this, World.class);
            startActivity(intent);
        } else if (id == R.id.nav_society) {
            JsonGet newsRequest = new JsonGet();
            ArrayList<NewsClass> news = newsRequest.getTwentyNewsfromSociety();
        } else if (id == R.id.nav_economics) {
            JsonGet newsRequest = new JsonGet();
            ArrayList<NewsClass> news = newsRequest.getTwentyNewsfromEconomics();
        } else if (id == R.id.nav_sports) {
            JsonGet newsRequest = new JsonGet();
            ArrayList<NewsClass> news = newsRequest.getTwentyNewsfromSports();
        } else if (id==R.id.nav_accidents){
            JsonGet newsRequest = new JsonGet();
            ArrayList<NewsClass> news = newsRequest.getTwentyNewsfromAccidents();
        } else if (id==R.id.nav_culture){
            JsonGet newsRequest = new JsonGet();
            ArrayList<NewsClass> news = newsRequest.getTwentyNewsfromCulture();
        } else if (id==R.id.nav_science){
            JsonGet newsRequest = new JsonGet();
            ArrayList<NewsClass> news = newsRequest.getTwentyNewsfromScience();
        } else if (id==R.id.nav_health){
            JsonGet newsRequest = new JsonGet();
            ArrayList<NewsClass> news =newsRequest.getTwentyNewsfromHealth();
        } else if (id==R.id.nav_technology){
            JsonGet newsRequest = new JsonGet();
            ArrayList<NewsClass> news = newsRequest.getTwentyNewsfromTechnology();
        } else if (id==R.id.nav_internet){
            JsonGet newsRequest = new JsonGet();
            ArrayList<NewsClass> news = newsRequest.getTwentyNewsfromInternet();
        } else if (id==R.id.nav_auto){
            JsonGet newsRequest = new JsonGet();
            ArrayList<NewsClass> news = newsRequest.getTwentyNewsfromAuto();
        } else if (id==R.id.nav_tourizm){
            JsonGet newsRequest = new JsonGet();
            ArrayList<NewsClass> news = newsRequest.getTwentyNewsfromTourism();
        } else if (id==R.id.nav_kazakh){
            JsonGet newsRequest = new JsonGet();
            ArrayList<NewsClass> news = newsRequest.getTwentyNewsfromKazakh();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
