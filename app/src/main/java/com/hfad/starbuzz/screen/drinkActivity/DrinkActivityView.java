package com.hfad.starbuzz.screen.drinkActivity;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(OneExecutionStateStrategy.class)
public interface DrinkActivityView extends MvpView {

    void showSelectedDrink(int imageResourceId, String name, String description);
}
