package com.infifox.fox.howhelper.base;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by jili on 2/24/17.
 */

public class BasePresenterImpl<S extends BaseSource, V extends BaseView> implements BasePresenter {

    protected final S mSource;

    protected V mView;

    protected CompositeSubscription mSubscriptions;

    public BasePresenterImpl(S source, V view) {
        this.mView = view;
        this.mSource = source;
        mView.setPresenter(this);
        mSubscriptions = new CompositeSubscription();
    }

    @Override
    public void start() {

    }

    @Override
    public void unSubscribe() {
        if (mSubscriptions != null && mSubscriptions.hasSubscriptions()) {
            mSubscriptions.unsubscribe();
            mSubscriptions.clear();
        }
    }
}