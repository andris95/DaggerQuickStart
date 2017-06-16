package com.boost.daggerquickstart.data;

import android.support.annotation.NonNull;

import com.boost.daggerquickstart.utils.PreferencesManager;

public class DataRepository implements DataSource {

    @Override
    public void loadData(@NonNull LoadDataCallback loadDataCallback) {
        String data = PreferencesManager.getInstance().getSavedData();
        loadDataCallback.onDataLoaded(data);
    }

    @Override
    public void saveData(@NonNull String data, @NonNull SaveDataCallback saveDataCallback) {
        PreferencesManager.getInstance().saveData(data);
        saveDataCallback.onDataSaved(data);
    }
}
