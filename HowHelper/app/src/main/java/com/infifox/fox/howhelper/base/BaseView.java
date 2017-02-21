package com.infifox.fox.howhelper.base;

import android.view.View;

/**
 * Created by jili on 11/9/16.
 */

public interface BaseView<T> {

    void setPresenter(T presenter);

    void showToast(String msg);

    void showToast(int msgId);

    void showSnackBar(View view, String msg);

    void showSnackBar(View view, int msg);
}

