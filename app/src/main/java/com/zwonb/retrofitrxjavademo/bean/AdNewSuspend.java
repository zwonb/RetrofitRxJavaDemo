package com.zwonb.retrofitrxjavademo.bean;


import java.io.Serializable;

/**
 * Created by LiuHuang on 2017/3/4.
 */
public class AdNewSuspend implements Serializable {

    /**
     * rightImg :
     * rightItem : {"url":"","type":""}
     * centerImg :
     * centerItem : {"url":"","type":""}
     */

    private String rightId;
    private String rightImg;
    private SkipTypeInfo rightItem;
    private String centerImg;
    private String centerId;
    private SkipTypeInfo centerItem;

    public String getCenterId() {
        return centerId;
    }

    public void setCenterId(String centerId) {
        this.centerId = centerId;
    }

    public String getRightId() {
        return rightId;
    }

    public void setRightId(String rightId) {
        this.rightId = rightId;
    }

    public String getRightImg() {
        return rightImg;
    }

    public void setRightImg(String rightImg) {
        this.rightImg = rightImg;
    }

    public SkipTypeInfo getRightItem() {
        return rightItem;
    }

    public void setRightItem(SkipTypeInfo rightItem) {
        this.rightItem = rightItem;
    }

    public String getCenterImg() {
        return centerImg;
    }

    public void setCenterImg(String centerImg) {
        this.centerImg = centerImg;
    }

    public SkipTypeInfo getCenterItem() {
        return centerItem;
    }

    public void setCenterItem(SkipTypeInfo centerItem) {
        this.centerItem = centerItem;
    }

}
