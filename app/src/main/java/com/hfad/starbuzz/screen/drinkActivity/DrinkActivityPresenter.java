package com.hfad.starbuzz.screen.drinkActivity;

import android.content.Intent;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.hfad.starbuzz.model.DrinkModel;

@InjectViewState
public class DrinkActivityPresenter extends MvpPresenter<DrinkActivityView> {
    public static final String EXTRA_DRINKNO = "drinkNo";

    private Integer drinkno;
    private DrinkModel drink;
    private Integer mImageResourceId;
    private String mName;
    private String mDescription;

    public void onGetSelectedDrinkFromIntent(Intent intent) {
        if (this.drinkno==null || intent.getExtras().getInt(EXTRA_DRINKNO)!=(this.drinkno)) {
            this.drinkno=intent.getExtras().getInt(EXTRA_DRINKNO);
            drink= DrinkModel.drinks[this.drinkno];
        mImageResourceId=drink.getImageResourceId();
        mName=drink.getName();
        mDescription=drink.getDescription();
        }
        getViewState().showSelectedDrink(mImageResourceId, mName, mDescription);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
