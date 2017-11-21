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

/**
 * Created by zwonb on 2017/11/20.
 */

public class RxJavaTest extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        initRxJava1();

//        initRxJava2();

        initRxJava3();
    }

    private void initRxJava1() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("binbin", "onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.e("binbin", "onNext: " + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("binbin", "onError");
            }

            @Override
            public void onComplete() {
                Log.e("binbin", "onComplete");
            }
        });
    }

    private void initRxJava2() {
        //调用onComplete或者onError之后上游(Observable)里面的继续执行
        //下游(Observer)执行完onComplete或者onError之后则不再执行
        //onComplete、onError互斥，onError多次调用会报错，onComplete多次调用不会报错
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                Log.e("binbin", "emit: " + 1);
                e.onNext(1);
                Log.e("binbin", "emit: " + 2);
                e.onNext(2);
                Log.e("binbin", "emit: complete");
                e.onComplete();
                Log.e("binbin", "emit: " + 3);
                e.onNext(3);
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("binbin", "onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.e("binbin", "onNext: " + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("binbin", "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.e("binbin", "onComplete");
            }
        });
    }

    private void initRxJava3() {
        //当下游调用Disposable.dispose()，则下游不再执行任何操作，上游继续发送
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                Log.e("binbin", "emit: " + 1);
                e.onNext(1);
                Log.e("binbin", "emit: " + 2);
                e.onNext(2);
                Log.e("binbin", "emit: complete");
                e.onComplete();
                Log.e("binbin", "emit: " + 3);
                e.onNext(3);
            }
        }).subscribe(new Observer<Integer>() {

            private Disposable mDisposable;

            @Override
            public void onSubscribe(Disposable d) {
                mDisposable = d;
            }

            @Override
            public void onNext(Integer integer) {
                Log.e("binbin", "onNext: " + integer);
                if (integer == 2) {
                    mDisposable.dispose();
                    Log.e("binbin", "disposable: " + mDisposable.isDisposed());
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.e("binbin", "onError");
            }

            @Override
            public void onComplete() {
                Log.e("binbin", "onComplete");
            }
        });
    }
}
