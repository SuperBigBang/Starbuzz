package com.hfad.starbuzz.screen.topLevelActivity;

import android.database.Cursor;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(OneExecutionStateStrategy.class)
public interface TopLevelView extends MvpView {

    void showDrinkCategoryActivity();

    void fillFavoritesList(Cursor cursor);

    void onFavoritesItemClicked(int id);
}
