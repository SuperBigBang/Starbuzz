package com.hfad.starbuzz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DrinkActivity extends AppCompatActivity {
    public static final String EXTRA_DRINKNO = "drinkNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        Intent intent=getIntent();
        int drinkNo=(Integer)getIntent().getExtras().get(EXTRA_DRINKNO);
        Drink drink = Drink.drinks[drinkNo];
        ImageView imageView= findViewById(R.id.photo);
        TextView nameView = findViewById(R.id.name);
        TextView descriptionView = findViewById(R.id.description);
        imageView.setImageResource(drink.getImageResourceId());
        imageView.setContentDescription(drink.getName());
        nameView.setText(drink.getName());
        descriptionView.setText(drink.getDescription());
    }
}
