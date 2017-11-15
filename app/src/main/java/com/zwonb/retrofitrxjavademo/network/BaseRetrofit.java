package com.zwonb.retrofitrxjavademo.network;

import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zwonb on 2017/11/14.
 */

public class BaseRetrofit {

    private static final String HTTPS = "HTTPS://";
    private static final String HTTP = "HTTP://";
    //测试服接口
//    private static final String HOSTNAME = "ceshi.yidont.com/app/ELifeTest/";
    //正式服接口
    private static final String HOSTNAME = "wzapi27.yidont.com/mobilem/app/ELife/";

    private volatile static BaseRetrofit mBaseRetrofit;

    private BaseRetrofit() {
    }

    public static BaseRetrofit getInstance() {
        if (mBaseRetrofit == null) {
            synchronized (BaseRetrofit.class) {
                if (mBaseRetrofit == null) {
                    mBaseRetrofit = new BaseRetrofit();
                }
            }
        }
        return mBaseRetrofit;
    }

    private Retrofit getRetrofits() {
        return new Retrofit.Builder()
                .baseUrl(HTTPS + HOSTNAME)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(BaseClient.getInstance().getClient())
                .build();
    }

    private Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(HTTP + HOSTNAME)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(BaseClient.getInstance().getClient())
                .build();
    }

    public static <T> T HTTPS(Class<T> t) {
        return getInstance().getRetrofits().create(t);
    }

    public static <T> T HTTP(Class<T> t) {
        return getInstance().getRetrofit().create(t);
    }

    //订阅
    public static <T> void SUBSCRIBE(Observable<T> observable, Observer<T> observer) {
        //集合线程调度
        observable.compose(RxSchedulers.<T>compose()).subscribe(observer);
    }
}
