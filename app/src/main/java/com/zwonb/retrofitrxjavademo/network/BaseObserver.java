package com.zwonb.retrofitrxjavademo.network;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.gson.JsonSyntaxException;
import com.zwonb.retrofitrxjavademo.AlApplication;
import com.zwonb.retrofitrxjavademo.R;

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

    private static final String TAG = "binbin";
    private FrameLayout mLoadLayout;
    private View mLoadView;
    private Context mContext;

    public BaseObserver(FrameLayout loadLayout) {
        this.mContext = AlApplication.getAppContext();
        mLoadView = LayoutInflater.from(mContext).inflate(R.layout.load_view, loadLayout, false);
        mLoadLayout = loadLayout;
        mLoadLayout.addView(mLoadView);
//        if (mContext instanceof Activity) {
//            FrameLayout decorView = (FrameLayout) ((Activity) mContext).getWindow().getDecorView();
//
//            mLoadLayout = ((FrameLayout) ((ViewGroup) ((ContentFrameLayout) ((FitWindowsLinearLayout) ((FrameLayout) ((LinearLayout) (decorView.getChildAt(0))).getChildAt(1)).getChildAt(0)).getChildAt(1)).getChildAt(0)).getChildAt(1));
//
//            mChildAt = ((ViewGroup) ((ContentFrameLayout) ((FitWindowsLinearLayout) ((FrameLayout) ((LinearLayout) (decorView.getChildAt(0))).getChildAt(1)).getChildAt(0)).getChildAt(1)).getChildAt(0));
//            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) mChildAt.getLayoutParams();
//            layoutParams.gravity = Gravity.CENTER;
//            layoutParams.topMargin = 210;
//            mChildAt.setLayoutParams(layoutParams);
//            mLoadLayout.addView(mChildAt);
//        }
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
                    Toast.makeText(mContext, "没有相关数据", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
            loadViewDismiss();
        }
    }

    protected void onSuccessOther(String ydCode, String ydMsg) {
    }

    @Override
    public void onError(@NonNull Throwable e) {
        loadViewDismiss();
        Log.e(TAG, "onError: " + e.toString());
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
                    Log.e("binbin", "网络错误: " + httpException.code());
                    //均视为网络错误
//                    mAlLoading.showBrokenNetworkDrawable();
                    break;
            }

        } else if (e instanceof TimeoutException || e instanceof SocketTimeoutException
                || e instanceof ConnectException) {
            Log.e("binbin", "onError: " + "连接超时");
//            if (mAlLoading != null) {
//                mAlLoading.showOverTimeDrawable();
//            }

        } else if (e instanceof JsonSyntaxException) {
            Log.e("binbin", "onError: " + "Json格式出错了");
            //假如导致这个异常触发的原因是服务器的问题，那么应该让服务器知道，所以可以在这里
            //选择上传原始异常描述信息给服务器
        }
//        else if (!ComNetWorkUtils.isNetConnected(AlApplication.getAppContext())) {
//            //手机断网，没有网络的情况
//            Log.e("binbin", "onError: " + "网络异常");
//
////            if (mAlLoading != null) {
////                mAlLoading.showBrokenNetworkDrawable();
////            }
////            if (mAlHeadView != null) {//头部有转圈
////                mAlHeadView.setAlNetWork(View.VISIBLE);//显示
////                mAlHeadView.setAlPbar(View.GONE);
////            }
//
//        }
        else {
            //其他情况
            Log.e("binbin", "onError: 未知错误==" + e.getMessage());
        }
    }

    @Override
    public void onComplete() {
        loadViewDismiss();
    }

    protected abstract void onSuccess(E e);

    protected void onError(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    private void loadViewDismiss() {
        mLoadLayout.removeView(mLoadView);
//        if (loadView != null && loadView.isShowing()) {
//            loadView.dismiss();
//        }
    }
}
