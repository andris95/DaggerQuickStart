package com.boost.daggerquickstart.screens.main.view;

import com.boost.daggerquickstart.BaseView;

public interface MainView extends BaseView {
    void onDataSaved(String data);
    void onDataLoaded(String data);
    void onError();
    void onLoadDataError();
    void onSaveDataError();
}
