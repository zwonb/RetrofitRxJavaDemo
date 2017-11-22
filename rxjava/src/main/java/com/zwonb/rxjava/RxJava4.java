package com.zwonb.rxjava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zwonb on 2017/11/21.
 */

public class RxJava4 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        init1();

//        init2();
    }

    private void init1() {
        //循环发送事件，内存无限增大，直到OOM
        Observable<Integer> observable1 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                for (int i = 0; ; i++) {
                    e.onNext(i);
                }
            }
        }).subscribeOn(Schedulers.io());

        Observable<String> observable2 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("a");
            }
        }).subscribeOn(Schedulers.io());

        Observable.zip(observable1, observable2, new BiFunction<Integer, String, String>() {
            @Override
            public String apply(Integer integer, String s) throws Exception {
                return integer + s;
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.e("binbin", "onNext: " + s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("binbin", throwable.getMessage());
                    }
                });

    }

    private void init2() {
        //当上下游工作在不同的线程中时, 这时候是一个异步的订阅关系
        //这个时候上游发送数据不需要等待下游接收, 为什么呢
        //因为两个线程并不能直接进行通信, 因此上游发送的事件并不能直接到下游里去
        //这个时候就需要一个田螺姑娘来帮助它们俩, 这个田螺姑娘就是我们刚才说的水缸
        //上游把事件发送到水缸里去, 下游从水缸里取出事件来处理
        //因此, 当上游发事件的速度太快, 下游取事件的速度太慢, 水缸就会迅速装满
        //然后溢出来, 最后就OOM了.
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                for (int i = 0; ; i++) {
                    e.onNext(i);
                }
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Thread.sleep(1000);
                        Log.e("binbin", "accept: " + integer);
                    }
                });
    }
}
