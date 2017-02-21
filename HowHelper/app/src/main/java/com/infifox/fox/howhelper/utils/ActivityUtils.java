package com.infifox.fox.howhelper.utils;

import com.infifox.fox.howhelper.app.HowHelperApplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by jili on 1/9/17.
 */

public class ActivityUtils {
    /**
     * 添加fragment到Activity中
     *
     * @param fragmentManager
     * @param showFragment
     * @param frameId
     */
    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,@NonNull Fragment showFragment, Fragment hideFragment,@NonNull String tag,int frameId){

        checkNotNull(fragmentManager);
        checkNotNull(showFragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if(hideFragment !=null){
            transaction.hide(hideFragment);

        }
        transaction.add(frameId,showFragment);
        transaction.show(showFragment);
        transaction.commit();

    }

    public static void showFragmentToActivity(@NonNull FragmentManager fragmentManager,@NonNull Fragment showFragment, @NonNull Fragment hideFragment ){
        checkNotNull(fragmentManager);
        checkNotNull(showFragment);
        Log.e(HowHelperApplication.TAG, "showFragmentToActivity");
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.hide(hideFragment);
        transaction.show(showFragment);
        transaction.commit();

    }

    public static void toDailysActivity(Context context){
            Intent intent = new Intent(context,DailyActivity.class);
        context.startActivity(intent);

    }
    public static void setVisible(boolean visible, View... view) {
        if (view != null) {
            if (visible) {
                for (View v : view) {
                    if (v != null)
                        v.setVisibility(View.VISIBLE);
                }
            } else {
                for (View v : view) {
                    if (v != null)
                        v.setVisibility(View.GONE);
                }
            }
        }
    }

    public static void toStoryDetailActivity(Context context, Story story) {
        Intent intent = new Intent(context, DetailActivity.class);
//        intent.putExtra(Constant.STORY_ID, storyId);
        intent.putExtra(Constant.STORY, story);
        context.startActivity(intent);
    }

    public static void toThemeDeatilsActivity(Context context, Story story) {
        Intent intent = new Intent(context, ThemeDetailActivity.class);
        intent.putExtra(Constant.STORY, story);
        context.startActivity(intent);
    }

    public static void toEditorListActivity(Context context, Theme theme) {
        Intent intent = new Intent(context, EditorActivity.class);
        intent.putExtra(Constant.THEME, theme);
        context.startActivity(intent);
    }

    public static void toCommentActivity(Context context, int storyId, StoryExtra storyExtra) {
        Intent intent = new Intent(context, CommentActivity.class);
        intent.putExtra(Constant.STORY_ID, storyId);
        if (storyExtra != null) {
            intent.putExtra(Constant.COMMENT_COUNT, storyExtra.getComments());
            intent.putExtra(Constant.LONG_COMMENT_COUNT, storyExtra.getLong_comments());
            intent.putExtra(Constant.SHORT_COMMENT_COUNT, storyExtra.getShort_comments());
        }
        context.startActivity(intent);
    }

    public static void toMyStarActivity(Context context) {
        Intent intent = new Intent(context, MyStarActivity.class);
        context.startActivity(intent);
    }

    public static void toEditorInfoActivity(Context context, Editor editor) {
        Intent intent = new Intent(context, EditorInfoActivity.class);
        intent.putExtra(Constant.EDITOR, editor);
        context.startActivity(intent);
    }

    public static void toLoginActivity(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    public static void toImageViewActivity(Activity activity, String imgPath, List<String> imgUrlList) {
        Intent intent = new Intent(activity, ImageViewActivity.class);
        intent.putExtra(Constant.IMG_URL, imgPath);
        intent.putExtra(Constant.IMG_URL_LIST, (Serializable) imgUrlList);
        ActivityCompat.startActivity(activity, intent, null);
    }

    public static void toSettingActivity(Context context) {
        context.startActivity(new Intent(context, SettingActivity.class));
    }

}
