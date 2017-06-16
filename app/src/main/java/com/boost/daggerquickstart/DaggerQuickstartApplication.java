package com.boost.daggerquickstart;

import android.app.Application;

import com.boost.daggerquickstart.app.AppComponent;
import com.boost.daggerquickstart.app.AppModule;
import com.boost.daggerquickstart.app.DaggerAppComponent;
import com.boost.daggerquickstart.app.MainPresenterModule;
import com.boost.daggerquickstart.utils.PreferencesManagerSingleton;

public class DaggerQuickstartApplication extends Application {
    private static AppComponent sAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        sAppComponent = buildAppComponent();
    }

    public static AppComponent getComponent() {
        return sAppComponent;
    }

    protected AppComponent buildAppComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .mainPresenterModule(new MainPresenterModule())
                .build();
    }
}
