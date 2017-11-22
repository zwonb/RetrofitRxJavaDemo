package com.zwonb.rxjava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zwonb on 2017/11/21.
 */

public class RxJava7 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        init1();
//        init2();
//        init3();
//        init4();
        init5();
    }

    private void init1() {
        //BackpressureStrategy.BUFFER,它没有大小限制
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> e) throws Exception {
                for (int i = 0; i < 1000; i++) {
                    e.onNext(i);
                    Log.e("binbin", "emit: " + i);
                }
            }
        }, BackpressureStrategy.BUFFER).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        Log.e("binbin", "onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e("binbin", "onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e("binbin", "onError: ", t);
                    }

                    @Override
                    public void onComplete() {
                        Log.e("binbin", "onComplete");
                    }
                });
    }

    private void init2() {
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> e) throws Exception {
                for (int i = 0; ; i++) {
                    e.onNext(i);
                }
            }
        }, BackpressureStrategy.BUFFER).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        Log.e("binbin", "onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e("binbin", "onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e("binbin", "onError: ", t);
                    }

                    @Override
                    public void onComplete() {
                        Log.e("binbin", "onComplete");
                    }
                });
    }

    private void init3() {
        //BackpressureStrategy.DROP 就是直接把存不下的事件丢弃,丢弃后面的
        /* 例子
        public void request() {
            mSubscription.request(128);
        }
        @see <a href="http://www.jianshu.com/p/a75ecf461e02"></a>
         */
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> e) throws Exception {
                for (int i = 0; i < 10000; i++) {
                    e.onNext(i);
                }
            }
        }, BackpressureStrategy.DROP).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        Log.e("binbin", "onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e("binbin", "onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e("binbin", "onError: ", t);
                    }

                    @Override
                    public void onComplete() {
                        Log.e("binbin", "onComplete");
                    }
                });
    }

    private void init4() {
        //BackpressureStrategy.LATEST 就是只保留最新的事件，丢弃前面的
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> e) throws Exception {
                for (int i = 0; i < 10000; i++) {
                    e.onNext(i);
                }
            }
        }, BackpressureStrategy.LATEST).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        Log.e("binbin", "onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e("binbin", "onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e("binbin", "onError: ", t);
                    }

                    @Override
                    public void onComplete() {
                        Log.e("binbin", "onComplete");
                    }
                });
    }

    private void init5() {
        // 有些FLowable并不是我自己创建的interval 操作符
        // 可以使用onBackpressureBuffer()、onBackpressureDrop()、onBackpressureLatest()
        Flowable.interval(1, TimeUnit.SECONDS)
                .onBackpressureBuffer() //加上被压策略
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.e("binbin", "accept: " + aLong);
                    }
                });
    }
}
