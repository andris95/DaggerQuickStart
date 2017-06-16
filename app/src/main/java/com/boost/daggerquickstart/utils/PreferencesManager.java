package com.boost.daggerquickstart.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesManager {
    public static final String TAG = PreferencesManager.class.getSimpleName();
    public static final String PREF_NAME = "PREFERENCES";

    private static SharedPreferences mSharedPreferences;
    private static Context mContext = null;

    private static SharedPreferences getSharedPreferences(Context context) {
        if (mSharedPreferences != null) {
            return mSharedPreferences;
        }
        mContext = context.getApplicationContext();
        mSharedPreferences = mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return mSharedPreferences;
    }
}
