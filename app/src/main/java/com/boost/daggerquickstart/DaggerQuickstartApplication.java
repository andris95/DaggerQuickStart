package com.boost.daggerquickstart;

import android.app.Application;

import com.boost.daggerquickstart.utils.PreferencesManager;

public class DaggerQuickstartApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        PreferencesManager.init(this);
    }
}
