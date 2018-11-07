package com.hfad.starbuzz.screen.drinkActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
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

    @BindView(R.id.favorite)
    CheckBox favoriteCheckBox;

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
    public void showSelectedDrink(int imageResourceId, String name, String description, boolean favorite) {
        imageView.setImageResource(imageResourceId);
        imageView.setContentDescription(name);
        nameView.setText(name);
        descriptionView.setText(description);
        favoriteCheckBox.setChecked(favorite);
    }

    public void onFavoriteClicked(View view) {
        mDrinkActivityPresenter.onFavoriteCheckBoxClicked(favoriteCheckBox.isChecked());
    }

    @Override
    public void changeFavoriteCheckBoxState(boolean favorite) {
        favoriteCheckBox.setChecked(favorite);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //    mDrinkActivityPresenter.onActivityDestroy();
    }
}
