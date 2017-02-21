package com.infifox.fox.howhelper.apis;

import com.infifox.fox.howhelper.app.Constants;
import com.infifox.fox.howhelper.bean.CardBackBean;
import com.infifox.fox.howhelper.bean.CardBean;
import com.infifox.fox.howhelper.bean.GithubBean;
import com.infifox.fox.howhelper.ui.main.activities.MainActivity;

import android.util.Log;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jili on 11/9/16.
 */

public class NetworkClient implements Constants {

    public static void getCardInfo(final MainActivity mainActivity) {
        ApiServices mApi = ServiceFactory.createServiceForm(ApiServices.class, ApiServices.HOST);
        mApi.getCardData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(mainActivity::updateUI);
    }

    public static void getCardInfo2(final MainActivity mainActivity) {
        ApiServices mApi = ServiceFactory.createServiceForm(ApiServices.class, ApiServices.HOST);
        mApi.getCardData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CardBean>() {
                    @Override
                    public void onCompleted() {

                        Log.d("ss", " get CardInfo2 completed ");
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.d("ss", " On Error get CardInfo2 " + e.getMessage().toString());
                        Log.d("ss", " On Error get CardInfo2 " + e.getStackTrace().toString());

                    }

                    @Override
                    public void onNext(CardBean cardBean) {
                        Log.d("ss", " on next " + cardBean.getName().toString());
                    }


                });
    }

    public static void getGitInfo(final MainActivity mainActivity) {
        ApiServices mApi = ServiceFactory.createServiceForm(ApiServices.class, ApiServices.HOST2);
        mApi.getGitData()
                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread()).subscribe(mainActivity::updateUI2);
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<GithubBean>() {
            @Override
            public void onCompleted() {
//                        Toast.makeText(MainActivity.this, "Get Top Movie Completed", Toast.LENGTH_SHORT).show();
                Log.d("ss", " completed ");
            }

            @Override
            public void onError(Throwable e) {
                Log.d("s", " On Error ");
            }

            @Override
            public void onNext(GithubBean githubBean) {
                Log.d("ss", githubBean.getEmail());
                Log.d("ss", githubBean.getAvatar_url());
                Log.d("ss", githubBean.getFollowers() + " ");
            }

        });
    }


    /**
     * card back info
     */
//    public static void getCardBackInfo(final MainActivity mainActivity){
//        ApiServices mApi = ServiceFactory.createServiceForm(ApiServices.class, Constants.CARD_BACK);
//        mApi.getCardBack()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread()).subscribe(mainActivity::updateUICardBack);
//    }
// card back is not vailed format for JSon //
    public static void getCardBackInfo(final MainActivity mainActivity) {
        Log.d("ss", " step1 ");

        ApiServices mApi = ServiceFactory.createServiceForm(ApiServices.class, ApiServices.HOST);
        mApi.getCardBack()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CardBackBean>() {
                    @Override
                    public void onCompleted() {
                        Log.d("ss", " completed ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("ss", " On Error " + e.toString());
                    }

                    @Override
                    public void onNext(CardBackBean cardBackItem) {
                        Log.d("ss", cardBackItem.toString());

                    }
                });
//                .observeOn(AndroidSchedulers.mainThread()).subscribe(mainActivity::updateUICardBack);
    }

}
