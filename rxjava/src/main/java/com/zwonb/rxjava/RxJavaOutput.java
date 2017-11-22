package com.zwonb.rxjava;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zwonb on 2017/11/22.
 */

public class RxJavaOutput extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        readFile();
    }

    private void readFile() {
        // 这个例子是读取一个文本文件，需要一行一行读取，然后处理并输出，
        // 如果文本文件很大的时候，比如几十M的时候，全部先读入内存肯定不是明智的做法，
        // 因此我们可以一边读取一边处理
        Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> e) throws Exception {
                try {
                    FileReader fileReader = new FileReader(Environment.getExternalStorageDirectory().getAbsolutePath()+"/test.txt");
                    BufferedReader bufferedReader = new BufferedReader(fileReader);

                    String str;
                    while ((str = bufferedReader.readLine()) != null && !e.isCancelled()) {
                        while (e.requested() == 0) {
                            if (e.isCancelled()) {
                                break;
                            }
                        }
                        e.onNext(str);
                    }

                    bufferedReader.close();
                    fileReader.close();
                    e.onComplete();
                } catch (IOException e1) {
                    e.onError(e1);
                }
            }
        }, BackpressureStrategy.ERROR).subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(new Subscriber<String>() {

                    private Subscription mSubscription;

                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(1);
                        mSubscription = s;
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("binbin", "onNext: " + s);
                        try {
                            Thread.sleep(1000);
                            mSubscription.request(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
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
}
