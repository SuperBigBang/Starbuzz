package com.hfad.starbuzz.di;

import android.content.Context;

import com.hfad.starbuzz.di.modules.ContextModule;
import com.hfad.starbuzz.di.modules.StarbuzzDatabaseHelperModule;
import com.hfad.starbuzz.screen.drinkActivity.DrinkActivityPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ContextModule.class, StarbuzzDatabaseHelperModule.class})
public interface BaseComponent {
    Context getContext();

    StarbuzzDatabaseHelperModule getStarbuzzDatabaseHelperModule();

    void inject(DrinkActivityPresenter drinkActivityPresenter);
}
