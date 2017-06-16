package com.boost.daggerquickstart.data;

import android.support.annotation.NonNull;

public interface DataSource {
    interface LoadDataCallback {
        void onDataLoaded(String data);
        void onError();
    }
    void loadData(@NonNull LoadDataCallback loadDataCallback);
}
