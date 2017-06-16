package com.boost.daggerquickstart;

import android.app.Application;

import com.boost.daggerquickstart.utils.PreferencesManagerSingleton;

public class DaggerQuickstartApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //PreferencesManagerSingleton.init(this);
    }
}
