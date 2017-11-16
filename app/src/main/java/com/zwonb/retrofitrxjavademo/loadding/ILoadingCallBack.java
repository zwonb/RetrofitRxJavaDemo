package com.zwonb.retrofitrxjavademo.loadding;

/**
 * Created by zwonb on 2017/11/16.
 */

public interface ILoadingCallBack {

    /**
     * 开始请求
     */
    default void onStart() {

    }

    /**
     * 请求成功，完成
     */
    default void onComplete() {

    }

    /**
     * 请求成功，没有数据
     */
    default void onNoData() {

    }

    /**
     * 请求失败
     */
    default void onError() {

    }
}
