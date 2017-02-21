package com.infifox.fox.howhelper.presenter.contract;

import com.infifox.fox.howhelper.base.BasePresenter;
import com.infifox.fox.howhelper.base.BaseView;

/**
 * Created by jili on 11/9/16.
 */

public interface AllCardContract {
    // ui
    interface View extends BaseView<BasePresenter> {

    }

    //data
    interface Presenter extends BasePresenter<View> {
        void getCardsData();
    }
}
