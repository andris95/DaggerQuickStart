package com.boost.daggerquickstart;

public interface MainContract {
    interface Presenter {
        void saveData(String data);
        void loadData();
    }
    interface View {
        void onDataSaved(String data);
        void onDataLoaded(String data);
        void onError();
    }
}
