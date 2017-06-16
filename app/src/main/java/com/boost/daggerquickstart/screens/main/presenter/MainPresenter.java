package com.boost.daggerquickstart.screens.main.presenter;

import com.boost.daggerquickstart.BasePresenter;

public interface MainPresenter extends BasePresenter{
    void saveData(String data);
    void loadData();
}
