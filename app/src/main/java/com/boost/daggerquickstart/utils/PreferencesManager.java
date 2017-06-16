package com.boost.daggerquickstart.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesManager {
    public static final String TAG = PreferencesManager.class.getSimpleName();
    public static final String PREF_NAME = "PREFERENCES";
    public static final String EXTRA_DATA = "EXTRA_DATA";

    private static PreferencesManager mInstance;
    private static SharedPreferences mSharedPreferences;

    private PreferencesManager(Context context) {
        mSharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static void init(Context context) {
        mInstance = new PreferencesManager(context);
    }

    public static PreferencesManager getInstance() {
        return mInstance;
    }

    private SharedPreferences getSharedPreferences() {
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
