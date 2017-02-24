package com.infifox.fox.howhelper.module.dailys;

import com.infifox.fox.howhelper.base.BasePresenter;
import com.infifox.fox.howhelper.base.BaseView;
import com.infifox.fox.howhelper.bean.Latest;
import com.infifox.fox.howhelper.bean.Story;
import com.infifox.fox.howhelper.bean.TopStory;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by jili on 2/24/17.
 *
 * /**
 * view 和 presenter 的联系类

*/

public interface DailyContract {

    interface View extends BaseView<Presenter> {

        void setRefreshLoadingIndicator(boolean active);

        void showTopStories(List<TopStory> topStories);

        void showStories(List<Story> stories);

        void showStoryDetailsUi(Story story);

        void showLoadingLatestError();

        void showNoStories();

        void addBefore(List<Story> stories);

        void showLoadingBeforeError();

        void showLatest(Latest latest);

        void setCurrentDate(String date);

        void showLoadMore(boolean active);
    }


    interface Presenter extends BasePresenter {

        void loadLatest(Context context, boolean getFromCache);

        void loadBefore(String date);

        void openStoryDetails(@NonNull Story item);

        void markReader(Context context, int id);

        List<Integer> getReaderList(Context context);
    }
}
