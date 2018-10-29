package com.hfad.starbuzz.screen.drinkActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.hfad.starbuzz.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DrinkActivity extends MvpAppCompatActivity implements DrinkActivityView {

    @InjectPresenter
    DrinkActivityPresenter mDrinkActivityPresenter;

    @BindView(R.id.photo)
    ImageView imageView;

    @BindView(R.id.name)
    TextView nameView;

    @BindView(R.id.description)
    TextView descriptionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        ButterKnife.bind(this);
        onGetIntent();
    }

    public void onGetIntent() {
        mDrinkActivityPresenter.onGetSelectedDrinkFromIntent(getIntent());
    }

    @Override
    public void showSelectedDrink(int imageResourceId, String name, String description) {
        imageView.setImageResource(imageResourceId);
        imageView.setContentDescription(name);
        nameView.setText(name);
        descriptionView.setText(description);
    }
}
