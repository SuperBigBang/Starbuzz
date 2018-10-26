package com.hfad.starbuzz.model;

import com.hfad.starbuzz.R;

public class DrinkModel {
    private  String name;
    private String description;
    private int imageResourceId;

    public static final DrinkModel[] drinks = {
            new DrinkModel("Latte","A couple of espresso shots with steamed milk", R.drawable.latte),
            new DrinkModel("Cappuccino", "Espresso, hot milk, and a steamed milk foam", R.drawable.cappuccino),
            new DrinkModel("Filter", "Highest quality beans roasted and brewed fresh", R.drawable.filter)
    };
    private DrinkModel(String name, String description, int imageResourceId){
        this.name=name;
        this.description=description;
        this.imageResourceId=imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
