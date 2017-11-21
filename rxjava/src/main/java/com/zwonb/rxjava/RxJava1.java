package com.zwonb.rxjava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zwonb on 2017/11/20.
 */

public class RxJava1 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        initRxJava1();

        initRxJava2();
    }

    private void initRxJava1() {
        //默认上游跟下游在同一个线程执行
        //subscribeOn 指定上游的工作线程，如果调用多个只有第一个生效其他无效
        //observeOn 指定下游的工作线程，可以调用多个(例子2)
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                Log.e("binbin", "Observable thread is: " + Thread.currentThread().getName());
                Log.e("binbin", "emit: " + 1);
                e.onNext(1);
            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e("binbin", "Observer thread is: " + Thread.currentThread().getName());
                        Log.e("binbin", "onNext: " + integer);
                    }
                });
    }

    private void initRxJava2() {
        //observeOn 指定下游的工作线程，可以调用多个
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                Log.e("binbin", "subscribe: " + Thread.currentThread().getName());
                Log.e("binbin", "emit: " + 1);
                e.onNext(1);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e("binbin", "doOnNext1: " + Thread.currentThread().getName());
                        Log.e("binbin", "doOnNext1: " + integer);
                    }
                })
                .observeOn(Schedulers.io())
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e("binbin", "doOnNext2: " + Thread.currentThread().getName());
                        Log.e("binbin", "doOnNext2: " + integer);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e("binbin", "accept: " + Thread.currentThread().getName());
                        Log.e("binbin", "accept: " + integer);
                    }
                });
        //关闭activity的时候需要clear,防止onNext操作ui异常
//        CompositeDisposable compositeDisposable = new CompositeDisposable();
//        compositeDisposable.add(d);
//        compositeDisposable.clear();
    }
}
