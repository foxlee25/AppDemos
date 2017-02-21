package com.infifox.fox.howhelper.apis;

import com.infifox.fox.howhelper.app.Constants;
import com.infifox.fox.howhelper.app.HowHelperApplication;
import com.infifox.fox.howhelper.utils.NetUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jili on 12/21/16.
 */

public class HSNetWorkClient {

    private static ApiServices mApiServices;
    private static OkHttpClient mOkHttpClient;
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();

    private static final int DEFAULT_TIMEOUT = 10;
    private static final int CACHE_SIZE = 10*1024*1024;

    private static final Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor(){
        @Override
        public Response intercept(Chain chain) throws IOException{
            Response originalResponse = chain.proceed(chain.request());
            if(NetUtils.isConnected((HowHelperApplication.getContext()))){
                int maxAge = 60; // cache available in 60 sec;
                return originalResponse.newBuilder().removeHeader("Pragma").removeHeader("Cache-Control").header("Cache-Control","public, max-age" + maxAge).build();
            }else {
                int maxState = 60*60*24*28;
                return originalResponse.newBuilder().removeHeader("Pragma").removeHeader("Cache-Control").header("Cache-Control","public, only-if-cached, max-stale=" + maxState).build();

            }
        }
    };
    public static ApiServices getApiService() {

        if (mApiServices == null) {
            if (mOkHttpClient == null) {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                // 设置超时时间
                builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
                builder.readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
                builder.writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
                // 添加缓存
                File cacheFile = new File(HowHelperApplication.getContext().getCacheDir(), "okHttpCache");
                builder.cache(new Cache(cacheFile, CACHE_SIZE));
                // 添加拦截器
                builder.addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        if (!NetUtils.isConnected(HowHelperApplication.getContext())) {
                            // 没有网络连接
                            request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
                        }
                        return chain.proceed(request);
                    }
                });
                builder.addNetworkInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
                        .addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR);
                mOkHttpClient = builder.build();
            }

            Retrofit retrofit = new Retrofit.Builder()
                    .client(mOkHttpClient)
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            mApiServices = retrofit.create(ApiServices.class);
        }
        return mApiServices;
    }


}
