package com.example.paktalin.lavina;

import android.graphics.Bitmap;

/**
 * Created by Paktalin on 14/05/2018.
 */

public class WineBottle {

    private String title, price, date, shop;
    private Bitmap image;

    WineBottle(String title, String price, Bitmap image) {
        this.title = title;
        this.price = price;
        this.image = image;
    }

    WineBottle(String title, String date, String shop, String price, Bitmap image) {
        this.title = title;
        this.date = date;
        this.shop = shop;
        this.price = price;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public Bitmap getImage() {
        return image;
    }

    public String getDate() {
        return date;
    }

    public String getShop() {
        return shop;
    }
}
