package com.zwonb.retrofitrxjavademo.bean;

import java.io.Serializable;

/**
 * Created by li4236 on 16/1/26.
 * 广告实体类
 */
public class YidontAdvertInfo implements Serializable {

    private String adId;   //   广告id

    private String adImg;  //  加载广告图片链接

    private String adTitle; // 广告标题

    private SkipTypeInfo adItem;

    //下面三个值50版本以下已抛弃

    private String adUrl;  //  广告链接

    private String adType; // 广告类型



    private String adScreen;//横屏、竖屏


    public SkipTypeInfo getAdItem() {
        return adItem;
    }

    public void setAdItem(SkipTypeInfo adItem) {
        this.adItem = adItem;
    }

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
    }

    public String getAdImg() {
        return adImg;
    }

    public void setAdImg(String adImg) {
        this.adImg = adImg;
    }

    public String getAdUrl() {
        return adUrl;
    }

    public void setAdUrl(String adUrl) {
        this.adUrl = adUrl;
    }

    public String getAdType() {
        return adType;
    }

    public void setAdType(String adType) {
        this.adType = adType;
    }

    public String getAdTitle() {
        return adTitle;
    }

    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle;
    }

    public String getAdScreen() {
        return adScreen;
    }

    public void setAdScreen(String adScreen) {
        this.adScreen = adScreen;
    }

    @Override
    public String toString() {
        return "YidontAdvertInfo{" +
                "adId='" + adId + '\'' +
                ", adImg='" + adImg + '\'' +
                ", adUrl='" + adUrl + '\'' +
                ", adType='" + adType + '\'' +
                ", adTitle='" + adTitle + '\'' +
                '}';
    }
}
