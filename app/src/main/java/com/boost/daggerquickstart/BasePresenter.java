package com.boost.daggerquickstart;

public interface BasePresenter {
    void attach(BaseView view);
    void detach();
}
