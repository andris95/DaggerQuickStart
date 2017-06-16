package com.boost.daggerquickstart.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

public class PreferencesManagerSingleton {
    public static final String TAG = PreferencesManagerSingleton.class.getSimpleName();
    public static final String PREF_NAME = "PREFERENCES";
    public static final String EXTRA_DATA = "EXTRA_DATA";

    private static PreferencesManagerSingleton mInstance;
    private static SharedPreferences mSharedPreferences;

    private String mKeyToListen;
    private SharedPreferences.OnSharedPreferenceChangeListener mOnSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            if (!TextUtils.isEmpty(mKeyToListen) && mKeyToListen.equals(key)) {
                Log.d(TAG, "onSharedPreferenceChanged: " + key + " changed");
            }
        }
    };

    private PreferencesManagerSingleton(Context context) {
        mSharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        mSharedPreferences.registerOnSharedPreferenceChangeListener(mOnSharedPreferenceChangeListener);
    }

    public static void init(Context context) {
        mInstance = new PreferencesManagerSingleton(context);
    }

    public static PreferencesManagerSingleton getInstance() {
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

    public String getKeyToListen() {
        return mKeyToListen;
    }

    public void setKeyToListen(String keyToListen) {
        mKeyToListen = keyToListen;
    }


}
