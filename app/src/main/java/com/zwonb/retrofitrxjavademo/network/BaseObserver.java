package com.zwonb.retrofitrxjavademo.network;


import android.util.Log;

import com.google.gson.JsonSyntaxException;
import com.zwonb.retrofitrxjavademo.loadding.LoadingImpl;
import com.zwonb.retrofitrxjavademo.utils.NetworkUtils;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * 添加一个通用的网络连接判断
 * RxJava Observable 订阅需要传入一个 Observer 对象，此处封装一个BaseObserver
 * Created by zyb on 2017/7/18.
 */

public abstract class BaseObserver<E> implements Observer<BaseBean<E>> {

    private LoadingImpl mLoading;

    public BaseObserver(LoadingImpl loading) {
        mLoading = loading;
        mLoading.onStart();
    }

    /**
     * 订阅前
     */
    @Override
    public void onSubscribe(@NonNull Disposable d) {
        //没有网络的情况
//        if (!NetworkUtils.isAvailableByPing()) {
//            d.dispose();
//            onComplete();
//            onError("网络异常");
//            Toast.makeText(mContext, "请检查您的网络", Toast.LENGTH_SHORT).show();
//        }
    }

    @Override
    public void onNext(@NonNull BaseBean<E> bean) {
        if (bean.isSuccess()) {
            E data = bean.getYdBody();
            onSuccess(data);
        } else {
            onSuccessOther(bean.getYdCode(), bean.getYdMsg());
            switch (bean.getYdCode()) {
                case "100004":
                    mLoading.onNoData();
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 不允许被重写
     */
    @Override
    public final void onError(@NonNull Throwable e) {
        if (e instanceof HttpException) {
            //HTTP错误 网络错误
            HttpException httpException = (HttpException) e;
            switch (httpException.code()) {
                case HttpCode.UNAUTHORIZED:
                case HttpCode.FORBIDDEN:
                case HttpCode.NOT_FOUND:
                case HttpCode.REQUEST_TIMEOUT:
                case HttpCode.GATEWAY_TIMEOUT:
                case HttpCode.INTERNAL_SERVER_ERROR:
                case HttpCode.BAD_GATEWAY:
                case HttpCode.SERVICE_UNAVAILABLE:
                default:
                    //均视为网络错误
                    onError("网络错误: " + httpException.code());
                    mLoading.onError("网络错误，错误代码：" + httpException.code() + "\n点击重试！");
                    break;
            }
        } else if (e instanceof TimeoutException || e instanceof SocketTimeoutException
                || e instanceof ConnectException) {
            onError("连接超时");
            mLoading.onTimeout();
        } else if (e instanceof JsonSyntaxException) {
            onError("Json格式出错了");
            mLoading.onError("Json格式异常错误：JsonSyntaxException\n点击重试！");
            //假如导致这个异常触发的原因是服务器的问题，那么应该让服务器知道，所以可以在这里
            //选择上传原始异常描述信息给服务器
        } else if (!NetworkUtils.isAvailableByPing()) {
            //手机断网，没有网络的情况
            onError("网络异常");
            mLoading.onError("网络异常，请检查你的网络状态！\n点击重试！");
        } else {
            //其他情况
            onError("未知错误==" + e.getMessage());
            mLoading.onError("未知错误\n点击重试！");
        }
    }

    @Override
    public void onComplete() {
        mLoading.onTimeout();
    }

    protected abstract void onSuccess(E e);

    /**
     * 请求成功后的其他状态码-由后台定
     */
    protected void onSuccessOther(String ydCode, String ydMsg) {
    }

    protected void onError(String msg) {
        Log.e("binbin", "网络请求错误: " + msg);
    }

}
