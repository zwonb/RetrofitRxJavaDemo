package com.zwonb.retrofitrxjavademo.network;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zwonb on 2017/11/14.
 */

public class BaseBean<E> {

    @SerializedName("ydCode")
    private String ydCode;
    @SerializedName("ydMsg")
    private String ydMsg;
    @SerializedName("ydBody")
    private E ydBody;

    public boolean isSuccess() {
        return ydCode.equals("100000");
    }

    public String getYdCode() {
        return ydCode;
    }

    public String getYdMsg() {
        return ydMsg;
    }

    public E getYdBody() {
        return ydBody;
    }

}
