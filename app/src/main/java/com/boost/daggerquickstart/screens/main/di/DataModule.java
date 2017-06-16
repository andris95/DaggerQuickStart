package com.boost.daggerquickstart.screens.main.di;

import android.content.Context;
import android.support.annotation.NonNull;

import com.boost.daggerquickstart.data.DataSource;
import com.boost.daggerquickstart.data.SPDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    @NonNull
    @Singleton
    public DataSource provideDataSource(Context context) {
        return new SPDataSource(context);
    }
}
