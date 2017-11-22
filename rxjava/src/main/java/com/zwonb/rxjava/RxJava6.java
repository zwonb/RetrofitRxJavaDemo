package com.zwonb.rxjava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zwonb on 2017/11/21.
 */

public class RxJava6 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        init1();
        init2();
    }

    private void init1() {
        // 我们把request当做是一种能力, 当成下游处理事件的能力
        // 下游能处理几个就告诉上游我要几个
        // 这样只要上游根据下游的处理能力来决定发送多少事件, 就不会造成一窝蜂的发出一堆事件来
        // 从而导致OOM. 这也就完美的解决之前我们所学到的两种方式的缺陷
        // 过滤事件会导致事件丢失, 减速又可能导致性能损失. 而这种方式既解决了事件丢失的问题
        // 又解决了速度的问题
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> e) throws Exception {
                Log.e("binbin", "emit 1");
                e.onNext(1);
                Log.e("binbin", "emit 2");
                e.onNext(2);
                Log.e("binbin", "emit 3");
                e.onNext(3);
                Log.e("binbin", "emit onComplete");
                e.onComplete();
            }
        }, BackpressureStrategy.ERROR).subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                Log.e("binbin", "onSubscribe");
                s.request(Long.MAX_VALUE); //这句必须添加，同步请求不添加报错
            }

            @Override
            public void onNext(Integer integer) {
                Log.e("binbin", "onNext: " + integer);
            }

            @Override
            public void onError(Throwable t) {
                Log.e("binbin", "onError", t);
            }

            @Override
            public void onComplete() {
                Log.e("binbin", "onComplete");
            }
        });
    }

    private void init2() {
        //不添加request(Long),异步不会报错
        // 为什么上下游没有工作在同一个线程时, 上游却正确的发送了所有的事件呢?
        // 这是因为在Flowable里默认有一个大小为128的水缸
        // 当上下游工作在不同的线程中时, 上游就会先把事件发送到这个水缸中
        // 因此, 下游虽然没有调用request, 但是上游在水缸中保存着这些事件
        // 只有当下游调用request时, 才从水缸里取出事件发给下游.
        /*  验证实例看
          @see <a href="http://www.jianshu.com/p/9b1304435564"></a>
         */
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> e) throws Exception {
                Log.e("binbin", "emit 1");
                e.onNext(1);
                Log.e("binbin", "emit 2");
                e.onNext(2);
                Log.e("binbin", "emit 3");
                e.onNext(3);
                Log.e("binbin", "emit onComplete");
                e.onComplete();
            }
        }, BackpressureStrategy.ERROR)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                Log.e("binbin", "onSubscribe");
//                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer integer) {
                Log.e("binbin", "onNext: " + integer);
            }

            @Override
            public void onError(Throwable t) {
                Log.e("binbin", "onError", t);
            }

            @Override
            public void onComplete() {
                Log.e("binbin", "onComplete");
            }
        });
    }
}
