package com.zwonb.retrofitrxjavademo.loadding;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.DrawableRes;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.zwonb.retrofitrxjavademo.AlApplication;
import com.zwonb.retrofitrxjavademo.R;

/**
 * 网络请求各种情况处理
 * Created by zwonb on 2017/11/16.
 */

public class LoadingImpl {

    private FrameLayout mLoadLayout;
    private IErrorClickAgain mClickAgain;
    private LinearLayout mPatentLayout;
    private ProgressBar mProgressBar;
    private ImageView mCentreImg;
    //    private ImageView mTimeOutImg;
//    private ImageView mErrorImg;
    private final TextView mContent;

    public LoadingImpl(FrameLayout loadLayout) {
        mLoadLayout = loadLayout;

        //各种情况的父布局
        LinearLayout.LayoutParams mParentParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        mPatentLayout = new LinearLayout(AlApplication.getAppContext());
        mPatentLayout.setLayoutParams(mParentParams);
        mPatentLayout.setBackgroundColor(Color.WHITE);
        mPatentLayout.setGravity(Gravity.CENTER);
        mPatentLayout.setOrientation(LinearLayout.VERTICAL);
        mPatentLayout.setFocusable(true);
        mPatentLayout.setClickable(true);

        //加载中
        LinearLayout.LayoutParams progressParams = new LinearLayout.LayoutParams(200, 200);
        mProgressBar = new ProgressBar(AlApplication.getAppContext());
        mProgressBar.setLayoutParams(progressParams);

        //没有数据
        LinearLayout.LayoutParams noDataParam = new LinearLayout.LayoutParams(450, 450);
        mCentreImg = new ImageView(AlApplication.getAppContext());
//        mCentreImg.setImageResource(R.mipmap.pic_no_data);
        mCentreImg.setLayoutParams(noDataParam);

        //超时
//        LinearLayout.LayoutParams timeOutParam = new LinearLayout.LayoutParams(450, 450);
//        mTimeOutImg = new ImageView(AlApplication.getAppContext());
//        mTimeOutImg.setImageResource(R.mipmap.pic_no_data);
//        mTimeOutImg.setLayoutParams(timeOutParam);

        //网络错误
//        LinearLayout.LayoutParams netErrorParam = new LinearLayout.LayoutParams(450, 450);
//        mErrorImg = new ImageView(AlApplication.getAppContext());
//        mErrorImg.setImageResource(R.mipmap.pic_time_out);
//        mErrorImg.setLayoutParams(netErrorParam);

        //图片下面的显示文字
        LinearLayout.LayoutParams textParam = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        textParam.topMargin = 30;
        mContent = new TextView(AlApplication.getAppContext());
        mContent.setTextSize(16);
        mContent.setTextColor(Color.GRAY);
        mContent.setLayoutParams(textParam);
        mContent.setTypeface(Typeface.DEFAULT_BOLD);
    }

    /**
     * 开始请求
     */
    public void onStart() {
        removeAllLoad();
        mPatentLayout.addView(mProgressBar);
        mLoadLayout.addView(mPatentLayout);
    }

    /**
     * 请求成功，完成
     */
    public void onComplete() {
        removeAllLoad();
    }

    /**
     * 请求成功，没有数据
     */
    public void onNoData() {
        setImgContent(R.mipmap.pic_no_data, "暂无数据", false);
    }

    /**
     * 请求超时
     */
    public void onTimeout() {
        setImgContent(R.mipmap.pic_time_out, "请求超时，点击重试！", true);
//        removeAllLoad();
//        mCentreImg.setImageResource(R.mipmap.pic_no_data);
//        mPatentLayout.addView(mTimeOutImg);
//        mLoadLayout.addView(mPatentLayout);
    }

    /**
     * 请求失败
     */
    public void onError(String msg) {
        setImgContent(R.mipmap.pic_network_error, msg, true);
//        removeAllLoad();
//        mPatentLayout.addView(mErrorImg);
//        mContent.setText(msg);
//        mPatentLayout.addView(mContent);
//        mLoadLayout.addView(mPatentLayout);
//        mPatentLayout.setOnClickListener(v -> {
//            if (mClickAgain != null) {
//                mClickAgain.onRequestAgain();
//            }
//        });
    }

    private void setImgContent(@DrawableRes int resId, String msg, boolean isRequestAgain) {
        removeAllLoad();
        if (mLoadLayout != null) {
            mCentreImg.setImageResource(resId);
            mPatentLayout.addView(mCentreImg);
            mContent.setText(msg);
            mPatentLayout.addView(mContent);
            mLoadLayout.addView(mPatentLayout);
            if (isRequestAgain) {
                mPatentLayout.setOnClickListener(v -> {
                    if (mClickAgain != null) {
                        mClickAgain.onRequestAgain();
                    }
                });
            }
        }
    }

    private void removeAllLoad() {
        if (mPatentLayout != null) {
            mPatentLayout.removeAllViews();
        }
        if (mLoadLayout != null) {
            mLoadLayout.removeView(mPatentLayout);
        }
    }

    public void setClickAgain(IErrorClickAgain clickAgain) {
        mClickAgain = clickAgain;
    }
}
