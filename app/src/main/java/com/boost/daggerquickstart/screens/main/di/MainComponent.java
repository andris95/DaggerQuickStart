package com.boost.daggerquickstart.screens.main.di;

import com.boost.daggerquickstart.app.AppModule;
import com.boost.daggerquickstart.screens.main.view.MainActivity;

import dagger.Component;
import dagger.Subcomponent;

@Subcomponent(modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
