package com.hfad.starbuzz.screen.drinkActivity;

import android.content.ContentValues;
import android.content.Intent;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.hfad.starbuzz.ExtendApplication;

@InjectViewState
public class DrinkActivityPresenter extends MvpPresenter<DrinkActivityView> {

    private Integer drinkno;
    private Integer mImageResourceId;
    private String mName;
    private String mDescription;
    private boolean mFavorite;

    public void onGetSelectedDrinkFromIntent(Intent intent) {
        if (mName == null) {
            if (this.drinkno == null || intent.getExtras().getInt(ExtendApplication.getBaseComponent().getStarbuzzDatabaseHelperModule().EXTRA_DRINKNO) != (this.drinkno)) {
                this.drinkno = intent.getExtras().getInt(ExtendApplication.getBaseComponent().getStarbuzzDatabaseHelperModule().EXTRA_DRINKNO);
                String[] drink = ExtendApplication.getBaseComponent().getStarbuzzDatabaseHelperModule()
                        .getItemSourceFromDatabase(Integer.toString(drinkno),
                                ExtendApplication.getBaseComponent().getContext());
                mName = drink[0];
                mDescription = drink[1];
                mImageResourceId = Integer.parseInt(drink[2]);
                if (drink[3] == null) {
                    mFavorite = false;
                } else {
                    mFavorite = ((Integer.parseInt(drink[3])) == 1);
                }
            }
            getViewState().showSelectedDrink(mImageResourceId, mName, mDescription, mFavorite);
        } else {
            getViewState().showSelectedDrink(mImageResourceId, mName, mDescription, mFavorite);
        }
    }

    public void onFavoriteCheckBoxClicked(boolean favoiteIsChecked) {
        ContentValues drinkValues = new ContentValues();
        drinkValues.put("FAVORITE", favoiteIsChecked);
        ExtendApplication.getBaseComponent().getStarbuzzDatabaseHelperModule().editDatabase(drinkValues, ExtendApplication.getBaseComponent().getContext(), Integer.toString(drinkno));
        mFavorite = favoiteIsChecked;
        getViewState().changeFavoriteCheckBoxState(mFavorite);
    }

    public void onActivityDestroy() {
        ExtendApplication.getBaseComponent().getStarbuzzDatabaseHelperModule().closeDatabaseAndCursor();
    }
}
