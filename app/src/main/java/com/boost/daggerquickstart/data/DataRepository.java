package com.boost.daggerquickstart.data;

import android.os.Handler;
import android.support.annotation.NonNull;

import com.boost.daggerquickstart.utils.PreferencesManager;

public class DataRepository implements DataSource {

    @Override
    public void loadData(@NonNull final LoadDataCallback loadDataCallback) {
        final String data = PreferencesManager.getInstance().getSavedData();
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
        PreferencesManager.getInstance().saveData(data);
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
