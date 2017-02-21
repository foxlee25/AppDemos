package com.infifox.fox.howhelper.base;

/**
 * Created by jili on 11/9/16.
 */

public interface BasePresenter<T extends BaseView<BasePresenter>>{

//    void attachView(T view);
//
//    void detachView();

    void start();

    void unSubScribe();
}