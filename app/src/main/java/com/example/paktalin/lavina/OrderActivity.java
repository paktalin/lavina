package com.example.paktalin.lavina;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;

import com.example.paktalin.lavina.adapters.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Paktalin on 14/05/2018.
 */

public class OrderActivity extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    Bitmap[] colorImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        expListView = findViewById(R.id.expandable_list_view);

        prepareListData();
        prepareColorImages();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild, colorImages);
        expListView.setAdapter(listAdapter);

        (findViewById(R.id.button_proceed)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this, QueryResultsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void prepareColorImages() {
        colorImages = new Bitmap[9];
        colorImages[0] = BitmapFactory.decodeResource(getResources(), R.drawable.color1);
        colorImages[1] = BitmapFactory.decodeResource(getResources(), R.drawable.color2);
        colorImages[2] = BitmapFactory.decodeResource(getResources(), R.drawable.color3);
        colorImages[3] = BitmapFactory.decodeResource(getResources(), R.drawable.color4);
        colorImages[4] = BitmapFactory.decodeResource(getResources(), R.drawable.color5);
        colorImages[5] = BitmapFactory.decodeResource(getResources(), R.drawable.color6);
        colorImages[6] = BitmapFactory.decodeResource(getResources(), R.drawable.color7);
        colorImages[7] = BitmapFactory.decodeResource(getResources(), R.drawable.color8);
        colorImages[8] = BitmapFactory.decodeResource(getResources(), R.drawable.color9);
    }

    private void prepareHeadersData() {
        String[] groups = new String[] {"COLOR", "BRAND", "PRICE", "YEAR", "STRENGTH", "REGION",
                "TITLE", "TYPE", "VARIETY"};
        listDataHeader = new ArrayList<>();
        listDataHeader.addAll(Arrays.asList(groups));
    }

    private void prepareListData() {
        prepareHeadersData();

        listDataChild = new HashMap<>();

        List<String> colors = new ArrayList<>();
        colors.addAll(Arrays.asList("Light-Bodied Red Wine", "Medium-Bodied Red Wine",
                "Full-Bodied Red Wine", "Old Red Wine", "Rosé Wine", "Light-Bodied White Wine",
                "Medium-Bodied White Wine", "Full-Bodied White Wine", "Old White Wine"));

        List<String> brands = new ArrayList<>();
        List<String> prices = new ArrayList<>();

        List<String> years = new ArrayList<>();
        years.addAll(Arrays.asList("2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007",
                "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018"));

        List<String> strengths = new ArrayList<>();
        List<String> regions = new ArrayList<>();
        regions.addAll(Arrays.asList("Abruzzo", "Apulia", "Basilicata", "Calabria", "Campania",
                "Emilia-Romagna", "Friuli-Venezia Giulia"));

        List<String> titles = new ArrayList<>();

        List<String> types = new ArrayList<>();
        types.addAll(Arrays.asList("Syrah", "Zinfandel", "Cabernet Sauvignon", "Pinot Noir",
                "Chardonnay", "Sauvignon Blanc", "Pinot Gris", "Riesling"));

        List<String> varieties = new ArrayList<>();

        listDataChild.put(listDataHeader.get(0), colors);
        listDataChild.put(listDataHeader.get(1), brands);
        listDataChild.put(listDataHeader.get(2), prices);
        listDataChild.put(listDataHeader.get(3), years);
        listDataChild.put(listDataHeader.get(4), strengths);
        listDataChild.put(listDataHeader.get(5), regions);
        listDataChild.put(listDataHeader.get(6), titles);
        listDataChild.put(listDataHeader.get(7), types);
        listDataChild.put(listDataHeader.get(8), varieties);
    }
}
