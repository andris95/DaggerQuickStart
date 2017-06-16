package com.boost.daggerquickstart.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

public class PreferencesManager {
    public static final String TAG = PreferencesManager.class.getSimpleName();
    public static final String PREF_NAME = "PREFERENCES";
    public static final String EXTRA_DATA = "EXTRA_DATA";

    private static PreferencesManager mInstance;
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

    private PreferencesManager(Context context) {
        mSharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        mSharedPreferences.registerOnSharedPreferenceChangeListener(mOnSharedPreferenceChangeListener);
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

    public String getKeyToListen() {
        return mKeyToListen;
    }

    public void setKeyToListen(String keyToListen) {
        mKeyToListen = keyToListen;
    }


}
