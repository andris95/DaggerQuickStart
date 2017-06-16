package com.boost.daggerquickstart;

import android.app.Application;

import com.boost.daggerquickstart.app.DependencyGraph;

public class DaggerQuickstartApplication extends Application {
    public static DependencyGraph dependencyGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        dependencyGraph = new DependencyGraph(this);
    }
}
