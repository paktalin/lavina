package com.example.paktalin.lavina.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.paktalin.lavina.R;
import com.example.paktalin.lavina.WineBottle;

/**
 * Created by Paktalin on 14/05/2018.
 */

public class WineAdapterCollection extends BaseAdapter {

    private LayoutInflater inflater;
    private WineBottle[] wines;

    public WineAdapterCollection(Context context, WineBottle[] wines) {
        this.wines = wines;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
            convertView = inflater.inflate(R.layout.item_wine_collection, null);
        }

        WineBottle bottle = (WineBottle)getItem(position);

        ((TextView)convertView.findViewById(R.id.wine_title)).setText(bottle.getTitle());
        ((TextView)convertView.findViewById(R.id.wine_date)).setText(bottle.getDate());
        ((TextView)convertView.findViewById(R.id.wine_shop)).setText(bottle.getShop());
        ((ImageView)convertView.findViewById(R.id.wine_image)).setImageBitmap(bottle.getImage());


        return convertView;
    }
}
