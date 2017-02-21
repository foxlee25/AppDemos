package com.infifox.fox.howhelper.apis;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jili on 11/13/16.
 */

public class ServiceFactory {

    /**
     *
     *
     */
    private static final int DEFAULT_TIME_OUT = 50;//超时时间 5s
    private static final int DEFAULT_READ_TIME_OUT = 10;



    //
    public static <T> T createServiceForm(final Class<T> serviceClass, String api){

//
//        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);//连接超时时间        builder.writeTimeout(DEFAULT_READ_TIME_OUT,TimeUnit.SECONDS);//写操作 超时时间
//        builder.readTimeout(DEFAULT_READ_TIME_OUT,TimeUnit.SECONDS);//读操作超时时间
//        // 添加公共参数拦截器
//        HttpCommonInterceptor commonInterceptor = new HttpCommonInterceptor.Builder()
//                .addHeaderParams("X-Mashape-Key","vnyskU48lSmshHOcUpJOe1dFteWxp1t3mvzjsnJVO7QuHLPmEu")
////                .addHeaderParams("userToken","1234343434dfdfd3434")
////                .addHeaderParams("userId","123445")
//                .build();
//        builder.addInterceptor(commonInterceptor);

        Retrofit adapter = new Retrofit.Builder()
                .baseUrl(api)
//                .client(builder.build())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return adapter.create(serviceClass);

    }

}
