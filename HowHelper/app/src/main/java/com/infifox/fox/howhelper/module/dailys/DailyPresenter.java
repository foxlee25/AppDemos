package com.infifox.fox.howhelper.module.dailys;

import com.infifox.fox.howhelper.base.BasePresenterImpl;
import com.infifox.fox.howhelper.bean.Story;
import com.infifox.fox.howhelper.data.DailySource;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by jili on 2/24/17.
 */

public class DailyPresenter extends BasePresenterImpl<DailySource,DailyContract.View> implements DailyContract.Presenter {

    public DailyPresenter(DailySource source,
            DailyContract.View view) {
        super(source, view);
    }

    @Override
    public void loadLatest(Context context, boolean getFromCache) {

    }

    @Override
    public void loadBefore(String date) {

    }

    @Override
    public void openStoryDetails(@NonNull Story item) {

    }

    @Override
    public void markReader(Context context, int id) {

    }

    @Override
    public List<Integer> getReaderList(Context context) {
        return null;
    }
}
