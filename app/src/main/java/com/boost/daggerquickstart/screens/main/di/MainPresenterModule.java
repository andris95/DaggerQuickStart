package com.boost.daggerquickstart.screens.main.di;

import android.content.Context;

import com.boost.daggerquickstart.data.DataSource;
import com.boost.daggerquickstart.data.SPDataSource;
import com.boost.daggerquickstart.screens.main.presenter.MainPresenter;
import com.boost.daggerquickstart.screens.main.presenter.MainPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class MainPresenterModule {

    @Provides
    public MainPresenter provideMainPresenter(DataSource dataSource) {
        return new MainPresenterImpl(dataSource);
    }

    @Provides
    public DataSource provideDataSource(Context context) {
        return new SPDataSource(context);
    }
}