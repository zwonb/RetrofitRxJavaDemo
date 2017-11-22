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
 * Created by zwonb on 2017/11/22.
 */

public class RxJava8 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        init1();
//        init2();
//        init3();
        init4();
    }

    private void init1() {
        //同一个主线程的
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
                Log.e("binbin", "current requested: " + emitter.requested());
            }
        }, BackpressureStrategy.ERROR)
                .subscribe(new Subscriber<Integer>() {

                    @Override
                    public void onSubscribe(Subscription s) {
                        Log.e("binbin", "onSubscribe");
                        s.request(10); //我要打十个！
//                        s.request(100);//这个会做累加
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
        //同一个主线程中，每发送一个就减少一个requested
        //下游调用request(n) 告诉上游它的处理能力，
        // 上游每发送一个next事件之后，requested就减一，
        // 注意是next事件，complete和error事件不会消耗requested，
        // 当减到0时，则代表下游没有处理能力了，这个时候你如果继续发送事件，
        // 会发生什么后果呢？当然是MissingBackpressureException啦
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> e) throws Exception {
                Log.e("binbin", "before emit request: " + e.requested());

                Log.e("binbin", "emit 1");
                e.onNext(1);
                Log.e("binbin", "after emit1 request: " + e.requested());

                Log.e("binbin", "emit 2");
                e.onNext(2);
                Log.e("binbin", "after emit2 request: " + e.requested());

                Log.e("binbin", "emit 3");
                e.onNext(3);
                Log.e("binbin", "after emit3 request: " + e.requested());


                Log.e("binbin", "emit 4");
                e.onNext(4);
                Log.e("binbin", "after emit4 request: " + e.requested());

                Log.e("binbin", "emit 5");
                e.onNext(5);
                Log.e("binbin", "after emit5 request: " + e.requested());

                Log.e("binbin", "emit 6");
                e.onNext(6);
                Log.e("binbin", "after emit6 request: " + e.requested());

                Log.e("binbin", "emit 7");
                e.onNext(7);
                Log.e("binbin", "after emit7 request: " + e.requested());

                Log.e("binbin", "emit 8");
                e.onNext(8);
                Log.e("binbin", "after emit8 request: " + e.requested());

                Log.e("binbin", "emit 9");
                e.onNext(9);
                Log.e("binbin", "after emit9 request: " + e.requested());

                Log.e("binbin", "emit onComplete");
                e.onComplete();
                Log.e("binbin", "after emit onComplete request: " + e.requested());

            }
        }, BackpressureStrategy.ERROR)
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        Log.e("binbin", "onSubscribe");
                        s.request(10);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e("binbin", "onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {
                        Log.e("binbin", "onComplete");
                    }
                });
    }

    private void init3() {
        //子线程中requested 默认是128个
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> e) throws Exception {
                Log.e("binbin", "request: " + e.requested());
            }
        }, BackpressureStrategy.ERROR).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        Log.e("binbin", "onSubscribe");
                        s.request(1000);
                    }

                    @Override
                    public void onNext(Integer integer) {

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void init4() {
        //说明当下游每消费96个事件便会自动触发内部的request()去设置上游的requested的值啊！
        // 没错，就是这样，而这个新的值就是96。
        /*
        public static void request() {
            mSubscription.request(96); //请求96个事件
        }
        @see <a href="http://www.jianshu.com/p/36e0f7f43a51"></a>
         */
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> e) throws Exception {

                Log.e("binbin", "First requested = " + e.requested());
                boolean flag;
                for (int i = 0; ; i++) {
                    flag = false;
                    while (e.requested() == 0) {
                        if (!flag) {
                            Log.e("binbin", "Oh no! I can't emit value!");
                            flag = true;
                        }
                    }
                    e.onNext(i);
                    Log.e("binbin", "emit " + i + " , requested = " + e.requested());
                }
            }
        }, BackpressureStrategy.ERROR).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        Log.e("binbin", "onSubscribe");
//                        mSubscription = s;
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e("binbin", "onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
