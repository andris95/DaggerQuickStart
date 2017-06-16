package com.boost.daggerquickstart.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

public class PreferencesManagerNonSingleton {
    public static final String TAG = PreferencesManagerNonSingleton.class.getSimpleName();
    public static final String PREF_NAME = "PREFERENCES";
    public static final String EXTRA_DATA = "EXTRA_DATA";

    private SharedPreferences mSharedPreferences;

    public PreferencesManagerNonSingleton(Context context) {
        mSharedPreferences = context.getSharedPreferences("PREFERENCES", Context.MODE_PRIVATE);
    }

    public SharedPreferences getSharedPreferences() {
        return mSharedPreferences;
    }

    public void saveData(String data) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(EXTRA_DATA, data);
        editor.apply();
    }

    public String getSavedData() {
        return getSharedPreferences().getString(EXTRA_DATA, null);
    }
}
