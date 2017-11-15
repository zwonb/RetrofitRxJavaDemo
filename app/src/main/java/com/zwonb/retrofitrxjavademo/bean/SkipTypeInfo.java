package com.zwonb.retrofitrxjavademo.bean;

import java.io.Serializable;

/**
 * Created by li4236 on 2017/3/4.
 */

public class SkipTypeInfo implements Serializable {

    /**
     * url :
     * type :
     */

    private String url;
    private String type;
    private String productCouponsValue;//商品优惠券的信息

    private long startTime;//封面开始时间【20170304新增】
    private long endTime;//封面结束时间【20170304新增】

    private String gameIco;//小图标【网游、HTML 游戏图标】
    private String gameTitle;//标题
    private String gameScreen;//横竖屏 （true 横屏，false 竖屏）

    private String productFrom;// 商品专题类型【可空】

    private String taoSide;
    private String taoSideName;
    private String taoSideTypeId;//十大分类里面的

    public String getTaoSide() {
        return taoSide;
    }

    public void setTaoSide(String taoSide) {
        this.taoSide = taoSide;
    }

    public String getTaoSideName() {
        return taoSideName;
    }

    public void setTaoSideName(String taoSideName) {
        this.taoSideName = taoSideName;
    }

    public String getTaoSideTypeId() {
        return taoSideTypeId;
    }

    public void setTaoSideTypeId(String taoSideTypeId) {
        this.taoSideTypeId = taoSideTypeId;
    }

    public String getProductFrom() {
        return productFrom;
    }

    public void setProductFrom(String productFrom) {
        this.productFrom = productFrom;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGameIco() {
        return gameIco;
    }

    public void setGameIco(String gameIco) {
        this.gameIco = gameIco;
    }

    public String getGameScreen() {
        return gameScreen;
    }

    public void setGameScreen(String gameScreen) {
        this.gameScreen = gameScreen;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setProductCouponsValue(String productCouponsValue) {
        this.productCouponsValue = productCouponsValue;
    }

    public String getProductCouponsValue() {
        return productCouponsValue;
    }

    @Override
    public String toString() {
        return "SkipTypeInfo{" +
                "endTime=" + endTime +
                ", url='" + url + '\'' +
                ", type='" + type + '\'' +
                ", productCouponsValue='" + productCouponsValue + '\'' +
                ", startTime=" + startTime +
                ", gameIco='" + gameIco + '\'' +
                ", gameTitle='" + gameTitle + '\'' +
                ", gameScreen='" + gameScreen + '\'' +
                ", productFrom='" + productFrom + '\'' +
                '}';
    }
}
