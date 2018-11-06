package com.hfad.starbuzz.screen.drinkActivity;

import android.content.Intent;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.hfad.starbuzz.ExtendApplication;

@InjectViewState
public class DrinkActivityPresenter extends MvpPresenter<DrinkActivityView> {

    public static final String EXTRA_DRINKNO = "drinkNo";

    private Integer drinkno;
    private Integer mImageResourceId;
    private String mName;
    private String mDescription;

    public void onGetSelectedDrinkFromIntent(Intent intent) {
        if (this.drinkno == null || intent.getExtras().getInt(EXTRA_DRINKNO) != (this.drinkno)) {
            this.drinkno = intent.getExtras().getInt(EXTRA_DRINKNO);
            String[] drink = ExtendApplication.getBaseComponent().getStarbuzzDatabaseHelperModule()
                    .getItemSourceFromDatabase(Integer.toString(drinkno),
                            ExtendApplication.getBaseComponent().getContext());
            mName = drink[0];
            mDescription = drink[1];
            mImageResourceId = Integer.parseInt(drink[2]);
        }
        getViewState().showSelectedDrink(mImageResourceId, mName, mDescription);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
