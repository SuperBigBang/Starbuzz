package com.hfad.starbuzz.screen.drinkActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.hfad.starbuzz.model.DrinkModel;
import com.hfad.starbuzz.R;

public class DrinkActivity extends AppCompatActivity {
    public static final String EXTRA_DRINKNO = "drinkNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        Intent intent=getIntent();
        int drinkNo=(Integer)getIntent().getExtras().get(EXTRA_DRINKNO);
        DrinkModel drink = DrinkModel.drinks[drinkNo];
        ImageView imageView= findViewById(R.id.photo);
        TextView nameView = findViewById(R.id.name);
        TextView descriptionView = findViewById(R.id.description);
        imageView.setImageResource(drink.getImageResourceId());
        imageView.setContentDescription(drink.getName());
        nameView.setText(drink.getName());
        descriptionView.setText(drink.getDescription());
    }
}
