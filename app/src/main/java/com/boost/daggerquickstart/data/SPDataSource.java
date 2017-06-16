package com.boost.daggerquickstart.data;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;

import com.boost.daggerquickstart.utils.PreferencesManager;

public class SPDataSource implements DataSource {
    private PreferencesManager mPreferencesManager;

    public SPDataSource(Context context) {
        PreferencesManager.init(context);
        mPreferencesManager = PreferencesManager.getInstance();
    }

    @Override
    public void loadData(@NonNull final LoadDataCallback loadDataCallback) {
        final String data = mPreferencesManager.getSavedData();
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
        mPreferencesManager.saveData(data);
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
