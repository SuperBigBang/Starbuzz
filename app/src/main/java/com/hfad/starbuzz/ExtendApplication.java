package com.hfad.starbuzz;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import com.hfad.starbuzz.di.BaseComponent;
import com.hfad.starbuzz.di.DaggerBaseComponent;
import com.hfad.starbuzz.di.modules.ContextModule;
import com.hfad.starbuzz.di.modules.StarbuzzDatabaseHelperModule;

import timber.log.Timber;

public class ExtendApplication extends Application {

    private static BaseComponent sBaseComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        sBaseComponent = DaggerBaseComponent.builder()
                .contextModule(new ContextModule(this))
                .starbuzzDatabaseHelperModule(new StarbuzzDatabaseHelperModule(this))
                .build();

    }

    public static BaseComponent getBaseComponent() {
        return sBaseComponent;
    }

    @VisibleForTesting
    public static void setBaseComponent(@NonNull BaseComponent baseComponent) {
        sBaseComponent = baseComponent;
    }
}