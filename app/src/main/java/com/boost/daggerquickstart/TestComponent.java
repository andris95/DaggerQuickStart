package com.boost.daggerquickstart;

import com.boost.daggerquickstart.view.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component
public interface TestComponent {
    void inject(MainActivity activity);
}
