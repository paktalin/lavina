package com.example.paktalin.lavina;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.paktalin.lavina.adapters.WineAdapterMain;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Bitmap[] winePics;
    String[] wineTitles, winePrices;
    WineBottle[] wines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        extractWinePics();
        extractWineTitles();
        extractWinePrices();

        setWineArray();

        WineAdapterMain adapter = new WineAdapterMain(MainActivity.this, wines);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void extractWinePrices() {
        winePrices = new String[] {
                "€7.90",
                "€8.85",
                "€13.50",
                "€5.74",
                "€8.00",
                "€15.90",
                "€11.50",
                "€9.79"};
    }

    private void setWineArray() {
        wines = new WineBottle[8];
        for (int i = 0; i < wines.length; i++) {
            wines[i] = new WineBottle(wineTitles[i], winePrices[i], winePics[i]);
        }
    }

    private void extractWineTitles() {
        wineTitles = new String[] {
                "Colli Euganei Bianco Olivetani Ca' Lustra 2015",
                "Pecorino Volo Di Berardino 2017",
                "Langhe Nebbiolo Bric Cenciurio 2016",
                "Grignolino Raniero Castello di Gabiano 2016",
                "Le Fattorie Tenuta di Frassineto 2014",
                "Doglio La Brugherata 2008",
                "Lagrein Hofstätter 2016",
                "Vermentino di Sardegna Cala Silente Santadi 2017"};
    }

    private void extractWinePics() {
        winePics = new Bitmap[8];
        winePics[0] = BitmapFactory.decodeResource(getResources(), R.drawable.wine1);
        winePics[1] = BitmapFactory.decodeResource(getResources(), R.drawable.wine2);
        winePics[2] = BitmapFactory.decodeResource(getResources(), R.drawable.wine3);
        winePics[3] = BitmapFactory.decodeResource(getResources(), R.drawable.wine4);
        winePics[4] = BitmapFactory.decodeResource(getResources(), R.drawable.wine5);
        winePics[5] = BitmapFactory.decodeResource(getResources(), R.drawable.wine6);
        winePics[6] = BitmapFactory.decodeResource(getResources(), R.drawable.wine7);
        winePics[7] = BitmapFactory.decodeResource(getResources(), R.drawable.wine8);
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
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.map) {
            Intent intent = new Intent(MainActivity.this, MapActivity.class);
            startActivity(intent);
        } else if (id == R.id.wine) {
            Intent intent = new Intent(MainActivity.this, OrderActivity.class);
            startActivity(intent);
        } else if (id == R.id.collection) {
            Intent intent = new Intent(MainActivity.this, CollectionActivity.class);
            startActivity(intent);

        } else if (id == R.id.community) {

        } else if (id == R.id.settings) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
