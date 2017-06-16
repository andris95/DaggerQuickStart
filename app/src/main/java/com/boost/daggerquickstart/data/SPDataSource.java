package com.boost.daggerquickstart.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.annotation.NonNull;

import com.boost.daggerquickstart.utils.PreferencesManagerNonSingleton;


public class SPDataSource implements DataSource {
    private SharedPreferences mSharedPreferences;

    public SPDataSource(Context context) {
        mSharedPreferences = context.getSharedPreferences("PREFERENCES", Context.MODE_PRIVATE);
    }

    @Override
    public void loadData(@NonNull final LoadDataCallback loadDataCallback) {
        final String data = mSharedPreferences.getString("KEY_DATA", null);
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
        mSharedPreferences.edit().putString("KEY_DATA", data).apply();
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
