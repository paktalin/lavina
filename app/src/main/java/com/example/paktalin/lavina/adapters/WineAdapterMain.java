package com.example.paktalin.lavina.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.paktalin.lavina.MapActivity;
import com.example.paktalin.lavina.R;
import com.example.paktalin.lavina.WineBottle;

/**
 * Created by Paktalin on 14/05/2018.
 */

public class WineAdapterMain extends BaseAdapter {

    private LayoutInflater inflater;
    private WineBottle[] wines;
    Context context;

    public WineAdapterMain(Context context, WineBottle[] wines) {
        this.wines = wines;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
    }

    @Override
    public int getCount() {
        return wines.length;
    }

    @Override
    public Object getItem(int position) {
        return wines[position];

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_wine_main, null);
        }

        WineBottle bottle = (WineBottle)getItem(position);

        ((TextView)convertView.findViewById(R.id.wine_title)).setText(bottle.getTitle());
        ((TextView)convertView.findViewById(R.id.wine_shop)).setText(bottle.getPrice());
        ((ImageView)convertView.findViewById(R.id.wine_image)).setImageBitmap(bottle.getImage());

        convertView.findViewById(R.id.button_order).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MapActivity.class);
                context.startActivity(intent);
            }
        });


        return convertView;
    }
}
