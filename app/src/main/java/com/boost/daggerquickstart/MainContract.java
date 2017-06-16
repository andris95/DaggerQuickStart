package com.boost.daggerquickstart;

public interface MainContract {
    interface Presenter {
        void saveData(String data);
    }
    interface View {
        void onDataSaved(String data);
    }
}
