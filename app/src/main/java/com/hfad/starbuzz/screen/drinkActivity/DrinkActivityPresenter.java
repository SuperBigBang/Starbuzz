package com.hfad.starbuzz.screen.drinkActivity;

import android.content.Intent;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.hfad.starbuzz.model.DrinkModel;

@InjectViewState
public class DrinkActivityPresenter extends MvpPresenter<DrinkActivityView> {
    public static final String EXTRA_DRINKNO = "drinkNo";

    private Intent intent;
    private DrinkModel drink;
    private Integer mImageResourceId;
    private String mName;
    private String mDescription;

    public void onGetSelectedDrinkFromIntent(Intent intent) {
        if (this.intent==null || intent.getExtras().getInt(EXTRA_DRINKNO)!=(this.intent.getExtras().getInt(EXTRA_DRINKNO))) {
            this.intent=intent;
            drink= DrinkModel.drinks[this.intent.getExtras().getInt(EXTRA_DRINKNO)];
        mImageResourceId=drink.getImageResourceId();
        mName=drink.getName();
        mDescription=drink.getDescription();
        }
        getViewState().showSelectedDrink(mImageResourceId, mName, mDescription);
    }

    @Override
    public void onDestroy() {
        intent=null;
        drink=null;
        mImageResourceId=null;
        mName=null;
        mDescription=null;
        super.onDestroy();
    }
}
