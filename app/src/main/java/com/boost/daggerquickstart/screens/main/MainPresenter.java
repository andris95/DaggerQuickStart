package com.boost.daggerquickstart.screens.main;

import com.boost.daggerquickstart.BaseView;
import com.boost.daggerquickstart.data.DataSource;
import com.boost.daggerquickstart.data.SPDataSource;

public class MainPresenter implements MainContract.Presenter {
    private String TAG = MainPresenter.class.getSimpleName();
    private MainContract.View mView;
    //private DataRepository mDataRepository = new DataRepository();
    private SPDataSource mSPDataSource;

    public MainPresenter(MainContract.View view) {
        mView = view;
    }

    public MainPresenter(MainContract.View view, SPDataSource SPDataSource) {
        mView = view;
        mSPDataSource = SPDataSource;
    }

    @Override
    public void saveData(final String data) {
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
        mView = (MainContract.View) view;
    }

    @Override
    public void onDetachView() {
        mView = null;
    }
}
