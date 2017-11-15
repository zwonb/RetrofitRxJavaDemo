package com.zwonb.retrofitrxjavademo.bean;



import java.util.List;

/**
 * Created by li4236 on 16/6/28.
 * li4236@aliyun.com
 */
public class IndexInfo {


    /**
     * userUid : 33
     * userPhone :
     * sysWebUrl : ceshi.yidont.com/app/ELife/
     * sysCoverId : 4
     * sysCoverImg : http://img23.yidont.com/img/ico/sys_activity/20151231125012_adpic.jpg
     * sysCoverUrl : http://www.baidu.com
     * sysCoverType : 2
     * sysDiscover : http://appweb.ed68.cn/find16517/
     * versionUpdate : false
     * systemNotice : 亿生活即将上线，敬请期待
     * callArre : 0
     * shopStatus : 跑腿送货上门
     * adList : [{"adImg":"http://elifeadmin.ed68.cn/data/upload/576a3fa488590.png","adUrl":"http://app.yitont.com","adType":"2"}]
     */

    private String userUid;
    private String userPhone;
    private String sysWebUrl;
    private String sysCoverId;
    private String sysCoverImg;
    private String sysCoverUrl;
    private String sysCoverType;
    private String sysDiscover;
    private boolean versionUpdate;
    private List<NoticeInfo> systemNotice;
    private int callArre;
    private String shopStatus;

    private boolean userGift;
    private String userGiftText1;
    private String userGiftText2;
    private String userGiftText3;
    private boolean registerStatus;

    private String activityImg;

    private String activityBtn;

    private String activityId;

    private SkipTypeInfo sysCoverItem;
    private AdNewSuspend adNewSuspend;

    private String publicPraiseUrl;

    public String getPublicPraiseUrl() {
        return publicPraiseUrl;
    }

    public void setPublicPraiseUrl(String publicPraiseUrl) {
        this.publicPraiseUrl = publicPraiseUrl;
    }


    public SkipTypeInfo getSysCoverItem() {
        return sysCoverItem;
    }

    public AdNewSuspend getAdNewSuspend() {
        return adNewSuspend;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    private List<IcoList> icoList;

    public List<IcoList> getIcoList() {
        return icoList;
    }

    public String getActivityImg() {
        return activityImg;
    }

    public void setActivityImg(String activityImg) {
        this.activityImg = activityImg;
    }

    public String getActivityBtn() {
        return activityBtn;
    }

    public void setActivityBtn(String activityBtn) {
        this.activityBtn = activityBtn;
    }

    public void setIcoList(List<IcoList> icoList) {
        this.icoList = icoList;
    }

    public static class IcoList {
        private String icoImgTrue;
        private String icoImgFalse;
        private String icoTitle;
        private boolean icoStatus;

        public boolean isIcoStatus() {
            return icoStatus;
        }

        public void setIcoStatus(boolean icoStatus) {
            this.icoStatus = icoStatus;
        }

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
    }


    public boolean isRegisterStatus() {
        return registerStatus;
    }

    public void setRegisterStatus(boolean registerStatus) {
        this.registerStatus = registerStatus;
    }


    public String getUserGiftText3() {
        return userGiftText3;
    }

    public void setUserGiftText3(String userGiftText3) {
        this.userGiftText3 = userGiftText3;
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

    public boolean isUserGift() {
        return userGift;
    }

    public void setUserGift(boolean userGift) {
        this.userGift = userGift;
    }


    private String wifiShareGold;//wifi首次分享送多少金币
    private String wifiShareGold2;//wifi二次分享送多少金币
    /**
     * adImg : http://elifeadmin.ed68.cn/data/upload/576a3fa488590.png
     * adUrl : http://app.yitont.com
     * adType : 2
     */

    private List<YidontAdvertInfo> adList;

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

    public boolean getVersionUpdate() {
        return versionUpdate;
    }

    public void setVersionUpdate(boolean versionUpdate) {
        this.versionUpdate = versionUpdate;
    }

    public List<NoticeInfo> getSystemNotice() {
        return systemNotice;
    }

    public void setSystemNotice(List<NoticeInfo> systemNotice) {
        this.systemNotice = systemNotice;
    }

    public int getCallArre() {
        return callArre;
    }

    public void setCallArre(int callArre) {
        this.callArre = callArre;
    }

    public String getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(String shopStatus) {
        this.shopStatus = shopStatus;
    }

    public List<YidontAdvertInfo> getAdList() {
        return adList;
    }

    public void setAdList(List<YidontAdvertInfo> adList) {
        this.adList = adList;
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

    public static class NoticeInfo {
        private String notice;

        public String getNotice() {
            return notice;
        }

        public void setNotice(String notice) {
            this.notice = notice;
        }
    }
}
