package com.boost.daggerquickstart.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesManager {
    public static final String TAG = PreferencesManager.class.getSimpleName();
    public static final String PREF_NAME = "PREFERENCES";
    public static final String EXTRA_DATA = "EXTRA_DATA";

    private static SharedPreferences mSharedPreferences;
    private static Context mContext = null;

    private SharedPreferences getSharedPreferences() {
        if (mSharedPreferences != null) {
            return mSharedPreferences;
        }
        mSharedPreferences = mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return mSharedPreferences;
    }

    public static void init(Context context) {
        mContext = context.getApplicationContext();
        mSharedPreferences = mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static SharedPreferences getInstance() {
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
