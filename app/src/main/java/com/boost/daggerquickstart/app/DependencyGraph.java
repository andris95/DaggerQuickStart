package com.boost.daggerquickstart.app;

import android.content.Context;

import com.boost.daggerquickstart.screens.main.di.MainComponent;
import com.boost.daggerquickstart.screens.main.di.MainModule;

public class DependencyGraph {
    private Context appContext;
    private AppComponent appComponent;
    private MainComponent mainComponent;

    public DependencyGraph(Context appContext) {
        this.appContext = appContext;
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(appContext))
                .build();
    }

    public MainComponent initMainComponent() {
        mainComponent = appComponent.mainComponent(new MainModule());
        return mainComponent;
    }
}
