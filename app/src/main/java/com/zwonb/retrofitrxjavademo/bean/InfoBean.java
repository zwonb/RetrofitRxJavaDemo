package com.zwonb.retrofitrxjavademo.bean;

import java.util.List;

/**
 * Created by zwonb on 2017/11/15.
 */

public class InfoBean {
    /**
     * userUid : 34
     * userPhone :
     * userGift : true
     * registerStatus : true
     * userGiftText1 : 赠送300金币
     * userGiftText2 : 30M全国流量
     * userGiftText3 : 30分钟时长
     * userVisit : true
     * sysWebUrl : ceshi.yidont.com/app/ELife/
     * sysCoverId : 4
     * sysCoverStartTime : 1488591212000
     * sysCoverEndTime : 1488591212000
     * sysCoverImg : HTTP: //img23.yidont.com/img/ico/sys_activity/20151231125012_adpic.jpg
     * sysCoverUrl : HTTP: //www.baidu.com
     * sysCoverType : 2
     * sysDiscover : HTTP: //appweb.ed68.cn/find16517/
     * versionUpdate : false
     * wifiShareGold : 300
     * wifiShareGold2 : 30
     * shopStatus : 跑腿送货上门
     * adList : [{"adImg":"HTTP: //elifeadmin.ed68.cn/data/upload/576a3fa488590.png","adUrl":"HTTP: //app.yitont.com","adType":"2"}]
     * icoList : [{"icoImgTrue":"HTTP: //elifeadmin.ed68.cn/data/upload/576a3fa488590.png","icoImgFalse":"HTTP: //elifeadmin.ed68.cn/data/upload/576a3fa488590.png","icoTitle":"今日签到","icoStatus":false}]
     * adSuspend : {"minType":"","minUrl":"","minImg":"HTTP: //elifeimg.oss-cn-beijing.aliyuncs.com/","minIco":"","minTitle":"","bigType":"2","bigUrl":"2482","bigImg":"HTTP: //elifeimg.oss-cn-beijing.aliyuncs.com/iconAd/1486950355665550.png","bigIco":"","bigTitle":""}
     */

    private String userUid;
    private String userPhone;
    private String userGift;
    private String registerStatus;
    private String userGiftText1;
    private String userGiftText2;
    private String userGiftText3;
    private String userVisit;
    private String sysWebUrl;
    private String sysCoverId;
    private String sysCoverStartTime;
    private String sysCoverEndTime;
    private String sysCoverImg;
    private String sysCoverUrl;
    private String sysCoverType;
    private String sysDiscover;
    private String versionUpdate;
    private String wifiShareGold;
    private String wifiShareGold2;
    private String shopStatus;
    private AdSuspendBean adSuspend;
    private List<AdListBean> adList;
    private List<IcoListBean> icoList;

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserGift() {
        return userGift;
    }

    public void setUserGift(String userGift) {
        this.userGift = userGift;
    }

    public String getRegisterStatus() {
        return registerStatus;
    }

    public void setRegisterStatus(String registerStatus) {
        this.registerStatus = registerStatus;
    }

    public String getUserGiftText1() {
        return userGiftText1;
    }

    public void setUserGiftText1(String userGiftText1) {
        this.userGiftText1 = userGiftText1;
    }

    public String getUserGiftText2() {
        return userGiftText2;
    }

    public void setUserGiftText2(String userGiftText2) {
        this.userGiftText2 = userGiftText2;
    }

    public String getUserGiftText3() {
        return userGiftText3;
    }

    public void setUserGiftText3(String userGiftText3) {
        this.userGiftText3 = userGiftText3;
    }

    public String getUserVisit() {
        return userVisit;
    }

    public void setUserVisit(String userVisit) {
        this.userVisit = userVisit;
    }

    public String getSysWebUrl() {
        return sysWebUrl;
    }

    public void setSysWebUrl(String sysWebUrl) {
        this.sysWebUrl = sysWebUrl;
    }

    public String getSysCoverId() {
        return sysCoverId;
    }

    public void setSysCoverId(String sysCoverId) {
        this.sysCoverId = sysCoverId;
    }

    public String getSysCoverStartTime() {
        return sysCoverStartTime;
    }

    public void setSysCoverStartTime(String sysCoverStartTime) {
        this.sysCoverStartTime = sysCoverStartTime;
    }

    public String getSysCoverEndTime() {
        return sysCoverEndTime;
    }

    public void setSysCoverEndTime(String sysCoverEndTime) {
        this.sysCoverEndTime = sysCoverEndTime;
    }

    public String getSysCoverImg() {
        return sysCoverImg;
    }

    public void setSysCoverImg(String sysCoverImg) {
        this.sysCoverImg = sysCoverImg;
    }

    public String getSysCoverUrl() {
        return sysCoverUrl;
    }

    public void setSysCoverUrl(String sysCoverUrl) {
        this.sysCoverUrl = sysCoverUrl;
    }

    public String getSysCoverType() {
        return sysCoverType;
    }

    public void setSysCoverType(String sysCoverType) {
        this.sysCoverType = sysCoverType;
    }

    public String getSysDiscover() {
        return sysDiscover;
    }

    public void setSysDiscover(String sysDiscover) {
        this.sysDiscover = sysDiscover;
    }

    public String getVersionUpdate() {
        return versionUpdate;
    }

    public void setVersionUpdate(String versionUpdate) {
        this.versionUpdate = versionUpdate;
    }

    public String getWifiShareGold() {
        return wifiShareGold;
    }

    public void setWifiShareGold(String wifiShareGold) {
        this.wifiShareGold = wifiShareGold;
    }

    public String getWifiShareGold2() {
        return wifiShareGold2;
    }

    public void setWifiShareGold2(String wifiShareGold2) {
        this.wifiShareGold2 = wifiShareGold2;
    }

    public String getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(String shopStatus) {
        this.shopStatus = shopStatus;
    }

    public AdSuspendBean getAdSuspend() {
        return adSuspend;
    }

    public void setAdSuspend(AdSuspendBean adSuspend) {
        this.adSuspend = adSuspend;
    }

    public List<AdListBean> getAdList() {
        return adList;
    }

    public void setAdList(List<AdListBean> adList) {
        this.adList = adList;
    }

    public List<IcoListBean> getIcoList() {
        return icoList;
    }

    public void setIcoList(List<IcoListBean> icoList) {
        this.icoList = icoList;
    }

    public static class AdSuspendBean {
        /**
         * minType :
         * minUrl :
         * minImg : HTTP: //elifeimg.oss-cn-beijing.aliyuncs.com/
         * minIco :
         * minTitle :
         * bigType : 2
         * bigUrl : 2482
         * bigImg : HTTP: //elifeimg.oss-cn-beijing.aliyuncs.com/iconAd/1486950355665550.png
         * bigIco :
         * bigTitle :
         */

        private String minType;
        private String minUrl;
        private String minImg;
        private String minIco;
        private String minTitle;
        private String bigType;
        private String bigUrl;
        private String bigImg;
        private String bigIco;
        private String bigTitle;

        public String getMinType() {
            return minType;
        }

        public void setMinType(String minType) {
            this.minType = minType;
        }

        public String getMinUrl() {
            return minUrl;
        }

        public void setMinUrl(String minUrl) {
            this.minUrl = minUrl;
        }

        public String getMinImg() {
            return minImg;
        }

        public void setMinImg(String minImg) {
            this.minImg = minImg;
        }

        public String getMinIco() {
            return minIco;
        }

        public void setMinIco(String minIco) {
            this.minIco = minIco;
        }

        public String getMinTitle() {
            return minTitle;
        }

        public void setMinTitle(String minTitle) {
            this.minTitle = minTitle;
        }

        public String getBigType() {
            return bigType;
        }

        public void setBigType(String bigType) {
            this.bigType = bigType;
        }

        public String getBigUrl() {
            return bigUrl;
        }

        public void setBigUrl(String bigUrl) {
            this.bigUrl = bigUrl;
        }

        public String getBigImg() {
            return bigImg;
        }

        public void setBigImg(String bigImg) {
            this.bigImg = bigImg;
        }

        public String getBigIco() {
            return bigIco;
        }

        public void setBigIco(String bigIco) {
            this.bigIco = bigIco;
        }

        public String getBigTitle() {
            return bigTitle;
        }

        public void setBigTitle(String bigTitle) {
            this.bigTitle = bigTitle;
        }
    }

    public static class AdListBean {
        /**
         * adImg : HTTP: //elifeadmin.ed68.cn/data/upload/576a3fa488590.png
         * adUrl : HTTP: //app.yitont.com
         * adType : 2
         */

        private String adImg;
        private String adUrl;
        private String adType;

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
    }

    public static class IcoListBean {
        /**
         * icoImgTrue : HTTP: //elifeadmin.ed68.cn/data/upload/576a3fa488590.png
         * icoImgFalse : HTTP: //elifeadmin.ed68.cn/data/upload/576a3fa488590.png
         * icoTitle : 今日签到
         * icoStatus : false
         */

        private String icoImgTrue;
        private String icoImgFalse;
        private String icoTitle;
        private boolean icoStatus;

        public String getIcoImgTrue() {
            return icoImgTrue;
        }

        public void setIcoImgTrue(String icoImgTrue) {
            this.icoImgTrue = icoImgTrue;
        }

        public String getIcoImgFalse() {
            return icoImgFalse;
        }

        public void setIcoImgFalse(String icoImgFalse) {
            this.icoImgFalse = icoImgFalse;
        }

        public String getIcoTitle() {
            return icoTitle;
        }

        public void setIcoTitle(String icoTitle) {
            this.icoTitle = icoTitle;
        }

        public boolean isIcoStatus() {
            return icoStatus;
        }

        public void setIcoStatus(boolean icoStatus) {
            this.icoStatus = icoStatus;
        }
    }
}
