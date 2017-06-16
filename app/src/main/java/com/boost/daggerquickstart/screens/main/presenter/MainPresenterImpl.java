package com.boost.daggerquickstart.screens.main.presenter;

import android.text.TextUtils;

import com.boost.daggerquickstart.BaseView;
import com.boost.daggerquickstart.R;
import com.boost.daggerquickstart.data.DataSource;
import com.boost.daggerquickstart.data.SPDataSource;
import com.boost.daggerquickstart.screens.main.view.MainView;

public class MainPresenterImpl implements MainPresenter {
    private String TAG = MainPresenter.class.getSimpleName();
    private MainView mView;
    private SPDataSource mSPDataSource;

    public MainPresenterImpl(MainView view) {
        mView = view;
    }

    public MainPresenterImpl(MainView view, SPDataSource SPDataSource) {
        mView = view;
        mSPDataSource = SPDataSource;
    }

    @Override
    public void saveData(final String data) {
        if (TextUtils.isEmpty(data)) {
            mView.onError(R.string.error_data_empty);
        } else {
            mSPDataSource.saveData(data, new DataSource.SaveDataCallback() {
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
        mSPDataSource.loadData(new DataSource.LoadDataCallback() {
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
    public void onAttachView(BaseView view) {
        mView = (MainView) view;
    }

    @Override
    public void onDetachView() {
        mView = null;
    }
}