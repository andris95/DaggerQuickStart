package com.boost.daggerquickstart.app;

import com.boost.daggerquickstart.screens.main.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class, MainPresenterModule.class})
@Singleton
public interface AppComponent {
    void inject(MainActivity activity);
}
