package com.zwonb.rxjava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zwonb on 2017/11/20.
 */

public class RxJava3 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init1();
    }

    private void init1() {
        //zip 操作符把两个Observable组合成一个新的Observable
        //适合一个界面请求两个不同接口的数据(合并数据)
        Observable<Integer> observable1 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                Log.e("binbin", "emit: " + 1);
                e.onNext(1);
                Thread.sleep(1000);

                Log.e("binbin", "emit: " + 2);
                e.onNext(2);
                Thread.sleep(1000);

                Log.e("binbin", "emit: " + 3);
                e.onNext(3);
                Thread.sleep(1000);

                Log.e("binbin", "emit: " + 4);
                e.onNext(4);
                Thread.sleep(1000);

                Log.e("binbin", "emit onComplete1");
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io());

        Observable<String> observable2 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                Log.e("binbin", "emit: a");
                e.onNext("a");
                Thread.sleep(1000);

                Log.e("binbin", "emit: b");
                e.onNext("b");
                Thread.sleep(1000);

                Log.e("binbin", "emit: c");
                e.onNext("c");
                Thread.sleep(1000);

                Log.e("binbin", "emit onComplete2");
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io());

        Observable.zip(observable1, observable2, new BiFunction<Integer, String, String>() {
            @Override
            public String apply(Integer integer, String s) throws Exception {
                return integer + s;
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Log.e("binbin", "onNext: " + s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.e("binbin", "onComplete");
            }
        });

    }

    private void requestAndRequest(){
        //zip 操作符适合将两个接口的数据合并成一个
//        public interface Api {
//            @GET
//            Observable<UserBaseInfoResponse> getUserBaseInfo(@Body UserBaseInfoRequest request);
//
//            @GET
//            Observable<UserExtraInfoResponse> getUserExtraInfo(@Body UserExtraInfoRequest request);
//
//        }

//        Observable<UserBaseInfoResponse> observable1 =
//                api.getUserBaseInfo(new UserBaseInfoRequest()).subscribeOn(Schedulers.io());
//
//        Observable<UserExtraInfoResponse> observable2 =
//                api.getUserExtraInfo(new UserExtraInfoRequest()).subscribeOn(Schedulers.io());
//
//        Observable.zip(observable1, observable2,
//                new BiFunction<UserBaseInfoResponse, UserExtraInfoResponse, UserInfo>() {
//                    @Override
//                    public UserInfo apply(UserBaseInfoResponse baseInfo,
//                                          UserExtraInfoResponse extraInfo) throws Exception {
//                        return new UserInfo(baseInfo, extraInfo);
//                    }
//                }).observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<UserInfo>() {
//                    @Override
//                    public void accept(UserInfo userInfo) throws Exception {
//                        //do something;
//                    }
//                });

    }
}
