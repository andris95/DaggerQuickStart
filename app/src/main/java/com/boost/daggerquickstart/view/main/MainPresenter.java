package com.boost.daggerquickstart.view.main;

import com.boost.daggerquickstart.BaseView;
import com.boost.daggerquickstart.data.DataRepository;
import com.boost.daggerquickstart.data.DataSource;

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
        mDataRepository.loadData(new DataSource.LoadDataCallback() {
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
