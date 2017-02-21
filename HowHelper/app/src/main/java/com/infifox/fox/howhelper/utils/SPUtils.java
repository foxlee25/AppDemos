package com.infifox.fox.howhelper.utils;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.content.SharedPreferencesCompat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by jili on 12/12/16.
 */

public class SPUtils {
    //Share preference Utils class

    private SPUtils(){

        throw  new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     *  the name of saved file in phone
     */

    public static final String FILE_NAME = "share_data";

    /**
     * 保持数据方法， 我们需要拿到数据的具体类型，然后对不同的数据类型调用不同的保存方法。
     */
     public static void put(Context context, String key , Object object){
         SharedPreferences sp = context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
         SharedPreferences.Editor editor = sp.edit();

         //
         if(object instanceof String){
            editor.putString(key,(String)object);
         }else if(object instanceof Integer){
             editor.putInt(key,(Integer)object);

         }else if(object instanceof Boolean){
            editor.putBoolean(key,(Boolean) object);
         }else if (object instanceof Float) {
             editor.putFloat(key, (Float) object);
         } else if (object instanceof Long) {
             editor.putLong(key, (Long) object);
         } else {
             editor.putString(key, object.toString());
         }

         editor.apply();

     }


    public static Object get(Context context, String key, Object defaultObject){
        return get(context, key ,defaultObject,false);
    }

    public static Object getFromDefaultPref(Context context, String key, Object defaultObject) {
        return get(context, key, defaultObject, true);
    }

    public static Object get(Context context, String key , Object defaultObject, boolean defaultPref){
        SharedPreferences sp;
        if(defaultPref){
            sp = PreferenceManager.getDefaultSharedPreferences(context);
        }else {
            sp = context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        }

        if(defaultObject instanceof String){
            return sp.getString(key,(String)defaultObject);
        }else if (defaultObject instanceof Integer) {
            return sp.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return sp.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float) {
            return sp.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long) {
            return sp.getLong(key, (Long) defaultObject);
        }


        return null;
    }


    /**
     * 移除某个key值已经对应的值
     *
     * @param context
     * @param key
     */
    public static void remove(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.apply();
    }

    public  static  void clear(Context context){

        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editoer = sp.edit();
        editoer.clear();
        editoer.apply();
    }


    /**
     * 查询某个key是否已经存在
     *
     * @param context
     * @param key
     * @return
     */
    public static boolean contains(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        return sp.contains(key);
    }



    /**
     * 返回所有的键值对
     *
     * @param context
     * @return
     */
    public static Map<String, ?> getAll(Context context){


        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return sp.getAll();
    }

    public static class SharePreferencesCompa{
        private static final Method sApplyMethod = findApplyMethod();

        @Nullable
        @SuppressWarnings({"unchecked", "rawtypes"})
        private static Method findApplyMethod() {
            try {
                Class clz = SharedPreferences.Editor.class;
                return clz.getMethod("apply");
            } catch (NoSuchMethodException e) {
            }

            return null;
        }

        /**
         * 如果找到则使用apply执行，否则使用commit
         *
         * @param editor
         */
        public static void apply(SharedPreferences.Editor editor) {
            try {
                if (sApplyMethod != null) {
                    sApplyMethod.invoke(editor);
                    return;
                }
            } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            editor.commit();
        }
    }


    }

