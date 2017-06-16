package com.boost.daggerquickstart.screens.main.presenter;

import android.text.TextUtils;

import com.boost.daggerquickstart.BaseView;
import com.boost.daggerquickstart.data.DataSource;
import com.boost.daggerquickstart.screens.main.view.MainView;

public class MainPresenterImpl implements MainPresenter {
    private String TAG = MainPresenter.class.getSimpleName();
    private MainView mView;
    private DataSource mDataSource;

    public MainPresenterImpl(DataSource dataSource) {
        mDataSource = dataSource;
    }

    @Override
    public void saveData(final String data) {
        if (TextUtils.isEmpty(data)) {
            mView.onSaveDataError();
        } else {
            mDataSource.saveData(data, new DataSource.SaveDataCallback() {
                @Override
                public void onDataSaved(final String data) {
                    mView.onDataSaved(data);
                }

                @Override
                public void onError() {
                    mView.onError();
                }
            });
        }
    }

    @Override
    public void loadData() {
        mDataSource.loadData(new DataSource.LoadDataCallback() {
            @Override
            public void onDataLoaded(final String data) {
                mView.onDataLoaded(data);
            }

            @Override
            public void onError() {
                mView.onError();
            }
        });
    }

    @Override
    public void attach(BaseView view) {
        mView = (MainView) view;
    }

    @Override
    public void detach() {
        mView = null;
    }
}