package com.boost.daggerquickstart;

public interface BasePresenter {
    void onAttachView(BaseView view);
    void onDetachView();
}
