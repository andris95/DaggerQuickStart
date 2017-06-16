package com.boost.daggerquickstart.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.annotation.NonNull;

import com.boost.daggerquickstart.utils.PreferencesManagerNonSingleton;


public class SPDataSource implements DataSource {
    private PreferencesManagerNonSingleton mPreferencesManagerNonSingleton;

    public SPDataSource(Context context) {
        mPreferencesManagerNonSingleton = new PreferencesManagerNonSingleton(context);
    }

    @Override
    public void loadData(@NonNull final LoadDataCallback loadDataCallback) {
        final String data = mPreferencesManagerNonSingleton.getSavedData();
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadDataCallback.onDataLoaded(data);
            }
        }, 1000);
    }

    @Override
    public void saveData(@NonNull final String data, @NonNull final SaveDataCallback saveDataCallback) {
        mPreferencesManagerNonSingleton.saveData(data);
        int delay = data.length() * 100;
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                saveDataCallback.onDataSaved(data);
            }
        }, delay);
    }
}
