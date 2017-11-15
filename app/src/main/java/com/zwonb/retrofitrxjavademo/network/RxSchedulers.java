package com.zwonb.retrofitrxjavademo.network;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

/**
 * 调度器
 * 在IO线程进行请求，在主线程进行回调
 * Created by zyb on 2017/7/18.
 */

public class RxSchedulers {

    public static <T> ObservableTransformer<T, T> compose() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(@NonNull Observable<T> upstream) {
                return upstream
//                        .delay(3000, TimeUnit.MILLISECONDS) //延迟订阅，防止阻塞ui
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
//                        .doOnSubscribe(new Consumer<Disposable>() {
//                            @Override
//                            public void accept(@NonNull Disposable disposable) throws Exception {
//                                //网络不可用
////                                if (!NetworkUtils.isConnected()) {
////                                    disposable.dispose();
////                                }
//                            }
//                        })
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
