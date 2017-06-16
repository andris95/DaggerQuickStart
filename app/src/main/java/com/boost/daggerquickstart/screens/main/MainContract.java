package com.boost.daggerquickstart.screens.main;

import com.boost.daggerquickstart.BasePresenter;
import com.boost.daggerquickstart.BaseView;

public interface MainContract {
    interface Presenter extends BasePresenter {
        void saveData(String data);
        void loadData();
    }
    interface View extends BaseView {
        void onDataSaved(String data);
        void onDataLoaded(String data);
        void onError();
    }
}
