package com.infifox.fox.howhelper.app;

import com.infifox.fox.howhelper.base.BaseActivity;
import com.infifox.fox.howhelper.base.BasePresenter;
import com.infifox.fox.howhelper.utils.SPUtils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jili on 11/9/16.
 */

public class HowHelperApplication extends Application{

    public static final String TAG = "HowHelper";

    private static  List<Activity> activityList =null;

    private static Context mContext;

    public static Context getAppContext(){

        return mContext;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getAppContext();
        //set night mode
        boolean isNightTime = (boolean) SPUtils.get(getApplicationContext(),Constants.KEY_NIGHT,false);
        if(isNightTime){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        activityList = new ArrayList<>();


    }
    //add activity to arraylist
    public static  void addActivity(Activity activity) {
        if(!activityList.contains(activity)){
            activityList.add(activity);
        }
    }

    public static void removeActivity(Activity activity ){
        if(activity!=null && activityList.contains(activity)){
            activityList.remove(activity);
        }
    }
    // remove all activitys

    public static void clearActivity(){
        if(activityList !=null){
            for(Activity activity : activityList){
                activity.finish();
                activityList =null ;
            }
        }
    }

    /**
     * exit app
     */
    private static long exitTime = 0;
    public static void exitApp(){
        if((System.currentTimeMillis() - exitTime ) > 2000){
            Toast.makeText(mContext, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        }else {

            clearActivity();
        }
    }

}
