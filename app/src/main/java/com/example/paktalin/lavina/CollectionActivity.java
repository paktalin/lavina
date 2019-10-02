package com.example.paktalin.lavina;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.paktalin.lavina.adapters.WineAdapterCollection;

/**
 * Created by Paktalin on 14/05/2018.
 */

public class CollectionActivity extends AppCompatActivity {

    Bitmap[] winePics;
    String[] wineTitles, wineDates, winePrices;
    WineBottle[] wines;
    private String[] wineShops;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        extractWinePics();
        extractWineTitles();
        extractWineDates();
        extractWineShops();
        extractWinePrices();

        setWineArray();

        WineAdapterCollection adapter = new WineAdapterCollection(CollectionActivity.this, wines);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }

    private void extractWineShops() {
        wineShops = new String[]{
                "Meat & Wine",
                "Meat & Wine",
                "Wine Not?",
                "Restoran Dominic",
                "Restoran Gloria",
                "Wine Not?",
                "Wine Not?",
                "Amalfi | Italian restaurant"};
    }

    private void extractWineDates() {
        wineDates = new String[] {
                "11 May",
                "7 May",
                "1 May",
                "20 Apr",
                "13 Apr",
                "8 Apr",
                "2 Apr",
                "30 Mar"};
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
            wines[i] = new WineBottle(wineTitles[i], wineDates[i], wineShops[i], winePrices[i], winePics[i]);
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
}
