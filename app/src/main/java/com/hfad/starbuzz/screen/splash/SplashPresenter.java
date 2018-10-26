package com.hfad.starbuzz.screen.splash;

import com.arellomobile.mvp.MvpPresenter;

public class SplashPresenter extends MvpPresenter<SplashView> {

    @Override
    public void attachView(SplashView view) {
        super.attachView(view);

        view.setAuthorized(false);
    }
}
