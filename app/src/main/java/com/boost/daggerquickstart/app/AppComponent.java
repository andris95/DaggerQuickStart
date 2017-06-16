package com.boost.daggerquickstart.app;

import com.boost.daggerquickstart.screens.main.di.MainComponent;
import com.boost.daggerquickstart.screens.main.di.MainModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {
    MainComponent mainComponent(MainModule mainModule);
}
