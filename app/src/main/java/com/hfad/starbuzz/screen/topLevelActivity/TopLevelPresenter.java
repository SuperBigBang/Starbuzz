package com.hfad.starbuzz.screen.topLevelActivity;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class TopLevelPresenter extends MvpPresenter<TopLevelView> {

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    public void onDrinkCategorySelection() {
        getViewState().showDrinkCategoryActivity();
    }
}
