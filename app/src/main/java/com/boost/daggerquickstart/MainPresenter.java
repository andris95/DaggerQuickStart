package com.boost.daggerquickstart;

import android.os.Handler;

import com.boost.daggerquickstart.utils.PreferencesManager;

public class MainPresenter implements MainContract.Presenter {
    private String TAG = MainPresenter.class.getSimpleName();
    private MainContract.View mView;

    public MainPresenter(MainContract.View view) {
        mView = view;
    }

    @Override
    public void saveData(final String data) {
        PreferencesManager.getInstance().saveData(data);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
               mView.onDataSaved(data);
            }
        }, 1000);
    }
}
