package com.zwonb.retrofitrxjavademo.bean;


import java.io.Serializable;
import java.util.List;

public class NovelBookBean implements Serializable {



    private AdNewSuspendBean adNewSuspend;
    private AdSuspendBean adSuspend;
    private List<NoveTypeBean> noveType;
    private List<NovelListBean> novelList;

    public AdNewSuspendBean getAdNewSuspend() {
        return adNewSuspend;
    }

    public void setAdNewSuspend(AdNewSuspendBean adNewSuspend) {
        this.adNewSuspend = adNewSuspend;
    }

    public AdSuspendBean getAdSuspend() {
        return adSuspend;
    }

    public void setAdSuspend(AdSuspendBean adSuspend) {
        this.adSuspend = adSuspend;
    }

    public List<NoveTypeBean> getNoveType() {
        return noveType;
    }

    public void setNoveType(List<NoveTypeBean> noveType) {
        this.noveType = noveType;
    }

    public List<NovelListBean> getNovelList() {
        return novelList;
    }

    public void setNovelList(List<NovelListBean> novelList) {
        this.novelList = novelList;
    }

    public static class AdNewSuspendBean {

        private String rightImg;
        private RightItemBean rightItem;
        private String centerImg;
        private CenterItemBean centerItem;

        public String getRightImg() {
            return rightImg;
        }

        public void setRightImg(String rightImg) {
            this.rightImg = rightImg;
        }

        public RightItemBean getRightItem() {
            return rightItem;
        }

        public void setRightItem(RightItemBean rightItem) {
            this.rightItem = rightItem;
        }

        public String getCenterImg() {
            return centerImg;
        }

        public void setCenterImg(String centerImg) {
            this.centerImg = centerImg;
        }

        public CenterItemBean getCenterItem() {
            return centerItem;
        }

        public void setCenterItem(CenterItemBean centerItem) {
            this.centerItem = centerItem;
        }

        public static class RightItemBean {

            private String url;
            private String type;

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
        }

        public static class CenterItemBean {

            private String url;
            private String type;

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
        }
    }

    public static class AdSuspendBean {

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

    public static class NoveTypeBean {

        private String noveTypeId;
        private String noveTypeName;
        private String noveTypeStyle;

        public String getNoveTypeId() {
            return noveTypeId;
        }

        public void setNoveTypeId(String noveTypeId) {
            this.noveTypeId = noveTypeId;
        }

        public String getNoveTypeName() {
            return noveTypeName;
        }

        public void setNoveTypeName(String noveTypeName) {
            this.noveTypeName = noveTypeName;
        }

        public String getNoveTypeStyle() {
            return noveTypeStyle;
        }

        public void setNoveTypeStyle(String noveTypeStyle) {
            this.noveTypeStyle = noveTypeStyle;
        }
    }

    public static class NovelListBean {

        private String novelKey;
        private String typeId;
        private String typeTitle;
        private String typeStyle;
        private String typeText;
        private String novelNum;
        private String novelImg;
        private String novelId;
        private String novelTitle;
        private String novelText;
        private String novelAuthor;
        private String novelOver;
        private String novelNumWords;
        private List<List<NovelSmallListBean>> novelSmallList;

        public String getNovelKey() {
            return novelKey;
        }

        public void setNovelKey(String novelKey) {
            this.novelKey = novelKey;
        }

        public String getTypeId() {
            return typeId;
        }

        public void setTypeId(String typeId) {
            this.typeId = typeId;
        }

        public String getTypeTitle() {
            return typeTitle;
        }

        public void setTypeTitle(String typeTitle) {
            this.typeTitle = typeTitle;
        }

        public String getTypeStyle() {
            return typeStyle;
        }

        public void setTypeStyle(String typeStyle) {
            this.typeStyle = typeStyle;
        }

        public String getTypeText() {
            return typeText;
        }

        public void setTypeText(String typeText) {
            this.typeText = typeText;
        }

        public String getNovelNum() {
            return novelNum;
        }

        public void setNovelNum(String novelNum) {
            this.novelNum = novelNum;
        }

        public String getNovelImg() {
            return novelImg;
        }

        public void setNovelImg(String novelImg) {
            this.novelImg = novelImg;
        }

        public String getNovelId() {
            return novelId;
        }

        public void setNovelId(String novelId) {
            this.novelId = novelId;
        }

        public String getNovelTitle() {
            return novelTitle;
        }

        public void setNovelTitle(String novelTitle) {
            this.novelTitle = novelTitle;
        }

        public String getNovelText() {
            return novelText;
        }

        public void setNovelText(String novelText) {
            this.novelText = novelText;
        }

        public String getNovelAuthor() {
            return novelAuthor;
        }

        public void setNovelAuthor(String novelAuthor) {
            this.novelAuthor = novelAuthor;
        }

        public String getNovelOver() {
            return novelOver;
        }

        public void setNovelOver(String novelOver) {
            this.novelOver = novelOver;
        }

        public String getNovelNumWords() {
            return novelNumWords;
        }

        public void setNovelNumWords(String novelNumWords) {
            this.novelNumWords = novelNumWords;
        }

        public List<List<NovelSmallListBean>> getNovelSmallList() {
            return novelSmallList;
        }

        public void setNovelSmallList(List<List<NovelSmallListBean>> novelSmallList) {
            this.novelSmallList = novelSmallList;
        }

        public static class NovelSmallListBean {

            private String img;
            private String bookId;
            private String title;
            private String author;
            private String ico;

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getBookId() {
                return bookId;
            }

            public void setBookId(String bookId) {
                this.bookId = bookId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getIco() {
                return ico;
            }

            public void setIco(String ico) {
                this.ico = ico;
            }
        }
    }
}
