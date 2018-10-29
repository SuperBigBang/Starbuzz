package com.hfad.starbuzz.screen.topLevelActivity;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(SkipStrategy.class)
public interface TopLevelView extends MvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showDrinkCategoryActivity();
}
