package com.infifox.fox.howhelper.data;

import com.infifox.fox.howhelper.base.BaseSource;
import com.infifox.fox.howhelper.bean.Latest;
import com.infifox.fox.howhelper.bean.Story;
import com.infifox.fox.howhelper.bean.TopStory;

import android.content.Context;

import java.util.List;

import rx.Observable;

/**
 * Created by jili on 2/24/17.
 */

public interface DailySource extends BaseSource {

    void saveCache(Context context, List<Story> stories, List<TopStory> top_stories);

    Observable<Latest> getCache(Context context);

    void saveReader(Context context, int id);

    List<Integer> getReader(Context context);

    List<Integer> getStarListId(Context context);

    Observable<Latest> loadLatest(Context context);

    Observable<Latest> loadBefore(String date);
}
