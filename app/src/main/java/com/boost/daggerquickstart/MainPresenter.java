package com.boost.daggerquickstart;

import android.os.Handler;

import com.boost.daggerquickstart.data.DataRepository;
import com.boost.daggerquickstart.data.DataSource;
import com.boost.daggerquickstart.utils.PreferencesManager;

public class MainPresenter implements MainContract.Presenter {
    private String TAG = MainPresenter.class.getSimpleName();
    private MainContract.View mView;
    private DataRepository mDataRepository = new DataRepository();

    public MainPresenter(MainContract.View view) {
        mView = view;
    }

    @Override
    public void saveData(final String data) {
        mDataRepository.saveData(data, new DataSource.SaveDataCallback() {
            @Override
            public void onDataSaved(final String data) {
                PreferencesManager.getInstance().saveData(data);
                Handler h = new Handler();
                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mView.onDataSaved(data);
                    }
                }, 1000);
            }

            @Override
            public void onError() {
                mView.onError();
            }
        });

    }

    @Override
    public void loadData() {
        mDataRepository.loadData(new DataSource.LoadDataCallback() {
            @Override
            public void onDataLoaded(String data) {
                mView.onDataLoaded(data);
            }

            @Override
            public void onError() {
                mView.onError();
            }
        });
    }
}
