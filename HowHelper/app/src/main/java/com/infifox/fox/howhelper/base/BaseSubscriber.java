package com.infifox.fox.howhelper.base;

import rx.Subscriber;

/**
 * Created by jili on 12/24/16.
 */

public abstract class BaseSubscriber<T> extends Subscriber<T> {

    public void onCompleted(){

    }

    public void onError(Throwable e){
        onFailure(e);
    }

    protected abstract void onFailure(Throwable e);

    public void onNext(T t){
        onSuccess(t);
    }

    protected abstract void onSuccess(T t);


}
