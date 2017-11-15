package com.zwonb.retrofitrxjavademo.network;


/**
 * Created by li4236 on 16/2/27.
 * 存放所有接口的act
 */
public class ActValue extends AlActValue {


    public static String STARTCOVER = "STARTCOVER";
    public static String STARTCOVERIMG = "STARTCOVERIMG";
    public static String AlCLOSE_CACHE = "CLOSECACHE";
    public static String AlCOVER_CACHE = "AlCOVERCACHE";



    public static String ACCESSSIGN = "accessSign";

    //程序报错信息
    public static String SysError = "sysError";
    //网页传递值
    public static String WebiewTitle = "WevViewTitle";

    public static String WebViewUrl = "WebViewUrl";

    public static String WebViewCollect = "WebViewCollect";

    public static String WebViewFloat = "WebViewFloat";

    public static String GameIco = "gameIco";

    public static String WebViewHead = "WebViewHead";

    public static String ApkId = "apkId";
    public static String ApkName = "apkName";
    public static String ApkPackage = "ApkPackage";


    public static String UpdateApk = "updateApk";

    public static String WebAction = "webAction";
    public static String Identity = "identity_flag";
    public static String IdentityPassword = "identity_flag_Password";


    ///////////////apk键值--Start////////////
    public static String ApkInfo = "apkInfo";
    public static String ApkExperience = "apkExperience";
    public static String ApkDown = "apkDown";
    public static String ApkClick = "apkClick";
    public static String ApkDownList = "apkDownList";


    ///////////////福利的键值--Start////////////
    public static String WelfareIndex = "welfareIndex";
    public static String WelfareList = "welfareList";
    public static String WelfareId = "welfareId";

    public static String ApkUpdateGet = "apkUpdateGet";
    public static String ApkUpdateInto = "apkUpdateInto";


    ///////////////首页的键值--Start////////////


    public static String ElifeFirst = "elifeFirst";
    public static String ElifeFirstShop = "elifeFirstShop";

    public static String Model = "model";

    public static String AgentId = "agentId";

    ///////////////首页的键值--End////////////

    ///////////////首页的保存键值--Start////////////
    public static String UserUid = "userUid";
    public static String UserPhone = "userPhone";
    public static String SysWebUrl = "sysWebUrl";
    public static String SysCoverId = "sysCoverId";
    public static String SysCoverImg = "sysCoverImg";
    public static String SysCoverUrl = "sysCoverUrl";
    public static String SysCoverType = "sysCoverType";
    public static String VersionUpdate = "versionUpdate";
    public static String CallArre = "callArre";//（//0没有，大于0则提示欠费多少）
    public static String Commons = "Commons_";//（//口碑
    public static String ShareGold = "shareGold";//wifi分享获得的金币
    public static String ShareGold2 = "shareGold2";//wifi二次分享获得的金币

    public static String UseGiftPackage = "useGiftPackage";//礼包领取

    public static String ActivityPackage = "activityPackage";//礼包领取
    public static String AactivityId = "activityId";//活动id


    ///////////////首页的保存键值--End////////////


    public static String Style = "style";

    //wifi相关
    public static String WifiSeach = "wifiSeach";
    public static String WifiName = "wifiName";//wifi名称
    public static String WifiMac = "wifiMac";//wifi的Mac
    public static String WifiPsk = "wifiPsk";//wifi的密码
    //wifi附近
    public static String WifiAround = "wifiRound";
    //分享wifi
    public static String WifiUp = "wifiUp";
    public static String kind = "kind";
    public static String DeviceType = "deviceType";// wifi路由型号
    public static String WifiTachometer = "wifiTachometer";// 网络测速
    //wifi认证
    public static String WifiAuthentication = "wifiAuthentication";
    public static String WifiAuthenticationInfo = "wifiAuthenticationInfo";//认证状态
    public static String ShopName = "shopName";
    public static String ShopAddress = "shopAddress";
    public static String StoreLogo = "storeLogo";


    ///////////////登录////////////
    public static String PhoneLogin = "phoneLogin";//登录

    ///////////////用户注册////////////
    public static String Phone = "phone";//要接受短信的号码（加密）
    ///////////////用户注册////////////

    ///////////////个人信息////////////
    public static String UseInfo = "useInfo";//个人信息
    public static String UserIco = "userIco";//个人头像
    public static String AccountUserName = "AccountUserName";//用户昵称
//    public static String LogPhone = "logPhone";//已登录的账户(加密)

    ///////////////注销登录////////////
    public static String PhoneRelieve = "phoneRelieve";

    ///////////////今日签到////////////
    public static String RegisterStatus = "registerStatus";//签到信息
    public static String Register = "register";//签到
    public static String RegisterRepair = "registerRepair";//补签
    public static String Data = "date";//补签日期
    ///////////////修改密码////////////
    public static String PhoneEditPass = "phoneEditPass";
    public static String Code = "code";

    ///////////////用户注册////////////
    public static String PhoneRegister = "phoneRegister";

    ///////////////意见反馈////////////
    public static String SysFeedback = "sysFeedback";
    public static String Text = "text";
    public static String Email = "email";

    ///////////////我的账单////////////
    public static String PhoneCheckBill = "phoneCheckBill";
    ///////////////删除账单////////////
    public static String PhoneDelCheckBill = "phoneDelCheckBill";
    ///////////////删除账单Id////////////
    public static String BillId = "billId";
    ///////////////客服列表////////////
    public static String CustomService = "customService";

    ///////////////摇一摇////////////
    public static String ShakeAwardList = "shakeAwardList";//获取摇红包信息
    //    public static String ShakeIng = "shakeIng";//摇一摇时
    public static String ShakeIngNew = "shakeIngNew";//摇一摇时
    public static String ShakeDraw = "shakeDraw";//领取礼包

    ///////////////注册后设置支付密码////////////
    public static String PhonePayPass = "phonePayPass";
    ///////////////重置支付密码获取验证码////////////
    public static String CodePayUpdate = "codePayUpdate";
    ///////////////修改支付密码////////////
    public static String PhoneResetPayPass = "phoneResetPayPass";
    ///////////////修改支付密码////////////
    public static String PhoneEditPayPass = "phoneEditPayPass";
    ///////////////旧密码////////////
    public static String OldPassword = "oldPassword";
    ///////////////新密码////////////
    public static String PhoneEditNewPayPass = "phoneEditNewPayPass";
    ///////////////提交个人信息////////////
    public static String UseInfoEdit = "useInfoEdit";

    ///////////////充值中心////////////
    public static String SureRecharge = "sureRecharge";//确认充值
    public static String SureRechargeNew = "sureRechargeNew";//确认充值
    public static String Province = "province";//手机归属地
    public static String RechargeId = "rechargeId";//充值id
    public static String OperateCode = "operateCode";//运营商代号
    public static String GoldPay = "goldPay";//金币支付
    public static String PayType = "payType";//支付类型约定
    public static String PayPass = "payPass";//支付密码
    public static String AlipayKey = "alipayKey";//获取支付宝信息
    public static String WeixinPay = "weixinPay";//获取微信支付信息


    /**
     * 游戏
     */
    public static final String GETKEY = "getKey";
    public static final String GAMEGETGIFT = "gameGetGift";
    public static final String MYGAME = "myGame";
    public static final String GAMEGIFT = "gameGift";
    public static final String GAMECENTERINFORMATION = "gameCenterInformation";
    public static final String GAMEHOTTEST = "gameHotTest";
    public static final String GAMEGIFTDETAILS = "gameGiftDetails";
    public static final String GAMEAUTHORIZATION = "gameAuthorization";
    public static final String GAMEID = "gameid";
    public static final String GAMEONLINEDETAILS = "gameOnlineDetails";
    public static final String GIFTID = "giftid";
    public static final String ID = "id";
    public static final String RECOMMENDGAME = "recommendgame";
    public static final String GameInGdexList = "gameIndexList";
    public static final String NEWGAME = "newgame";
    public static final String GAMESEARCH = "gameSearch";
    public static final String GAMEHOTSEARCH = "gameHotSearch";
    public static final String HOTGAME = "hotgame";
    public static final String GAMESPECIAL = "gamespecial";
    public static final String PAGE = "page";
    public static final String TYPESINGLEGAME = "0";
    public static final String TYPEONLINEGAME = "1";

    public static final String MyRecharge = "myRecharge";//充值记录
    public static final String RechargeType = "rechargeType";//充值类型（1时长，2话费，3流量）
    public static final String DelRecharge = "delRecharge";//删除充值记录
    ///////////////超市分类显示数据////////////
    public static final String IndexList = "indexList";//操作类型
    public static final String Lat = "lat";//纬度
    public static final String Lon = "lon";//经度
    public static final String Page = "page";//分页
    public static final String OrderKey = "orderKey";//查询键值
    public static final String Orderby = "orderby";//升序还是降序
    public static final String OrderSure = "orderSure";//确定下单
    public static final String Products = "products";//商品ID，数量|商品ID，数量
    public static final String OrderRefer = "orderRefer";//确定定单myOrderScan
    public static final String Name = "name";
    public static final String SendTtime = "sendTtime";
    public static final String Address = "address";
    ///////////////获取店铺信息////////////
    public static final String ShopInfo = "shopInfo";//操作类型
    public static final String ShopId = "shopId";//商铺id （加密）
    public static final String ShopTypeInfo = "shopTypeInfo";//根据id获取分类商品
    public static final String ProductTypeId = "productTypeId";//分类id
    public static final String ShopSearch = "shopSearch";//搜索商铺里面的商品
    public static final String Value = "value";//搜索关键词
    public static final String CollectList = "collectList";//店铺收藏
    public static final String CollectAdd = "collectAdd";//添加收藏
    public static final String CollectDel = "collectDel";//删除店铺收藏
    ///////////////我的订单////////////
    public static final String MyOrder = "myOrder";//我的订单
    public static final String Status = "status";//订单类型
    public static final String MyOrderInfo = "myOrderInfo";//订单详情
    public static final String MyOrderCancel = "myOrderCancel";//取消订单
    public static final String MyOrderRefuse = "myOrderRefuse";//拒绝收货
    public static final String MyOrderScan = "myOrderScan";//扫码支付
    public static final String MyOrderRated = "myOrderRated";//评价订单
    public static final String MyOrderDel = "myOrderDel";//删除订单
    public static final String OrderId = "orderId";//订单id
    public static final String RatedStar = "ratedStar";//评价星级
    public static final String RatedText = "RatedText";//评价内容
    public static final String RateHide = "rateHide";//匿名评价
    ///////////////幸运抽奖点击领取商品////////////
    public static final String LuckDraw = "luckDraw";//操作类型
    public static final String LotteryId = "lotteryId";//抽奖记录id(加密)
    public static final String LotteryType = "lotteryType";//类型 1是幸运抽奖，2是抢疯了活动,3是其他活动

    public static final String VideoPosition = "VideoPosition";//视频位置
    ///////////////商品兑换////////////
    public static final String ShopOnlineSure = "shopOnlineSure";//点击结算
    public static final String ShopOnlineRefer = "shopOnlineRefer";//确认下单
    public static final String ProductId = "productId";//商品ID
    public static final String ProductNum = "productNum";//购买数量
    public static final String ProductSpecOne = "productSpecOne";//规格1
    public static final String ProductSpecTwo = "productSpecTwo";//规格2

    public static final String Type = "type";//0:好友分享、1:二维码邀请
    public static final String ShareInfo = "shareInfo";//好友分享
    public static final String ShareToday = "shareToday";//今日邀请战绩
    public static final String ShareNewPattern = "shareNewPattern";//二元次分享套餐获取
    public static final String ShareUrl = "shareUrl";//好友分享连接
    public static final String ShareNewPatternUrl = "shareNewPatternUrl";//邀请好友
    public static final String ShareId = "shareId";//邀请好友ID
    ///////////////流量银行////////////
    public static final String MyFlowBank = "myFlowBank";//流量银行首页
    public static final String FlowBankList = "flowBankList";//流量提现
    public static final String FlowExtract = "flowExtract";//流量提现确认
    public static final String FlowRefer = "flowRefer";//流量借贷确认
    public static final String FlowBankId = "flowBankId";//流量套餐id
    public static final String FlowOperateList = "flowOperateList";//流量赠送
    public static final String FlowSend = "flowSend";//流量赠送确定
    public static final String MyFlowRefer = "myFlowRefer";//流量借还记录
    public static final String FlowRepaySure = "flowRepaySure";//还流量--下单
    public static final String FlowBankNum = "flowBankNum";//还流量数量
    public static final String FlowRepay = "flowRepay";//使用流量包还
    public static final String FlowType = "flowType";//记录类型(1 借，2还)
    public static final String Carry = "carry";//提现
    public static final String Borrow = "borrow";//借

    public static final String GetRedPacket = "getRedPacket";//拆红包
    public static final String RedPacketResult = "redPacketResult";//领取红包
    public static final String ShopSnapUp = "shopSnapUp";//抢疯了
    public static final String ShopSnapUpNew = "shopSnapUpNew";//2.0.5版本之后抢疯了
    public static final String TimeId = "timeId";//时间id；
    //public static final String ShopOnlineRecord = "shopOnlineRecord";//个人兑换记录
    public static final String ShopSnapUpRecord = "shopSnapUpRecord";//抢购记录
    //public static final String FiveGoMyRecord = "fiveGoMyRecord";//5折购记录
    public static final String MyAllRecord = "myAllRecord";//全部购物记录
    public static final String OrderStatus = "orderStatus";//全部购物记录【状态：0 全部，1 未领取，2未付款，3待发货，4已发货】
    ///////////////金币商城////////////
    public static final String ShopOnline = "shopOnline";//金币商城首页
    public static final String ShopOnlineType = "shopOnlineType";//根据id获取分类数据
    public static final String TypeId = "typeId";//分类id
    public static final String ShopOnlineSearch = "shopOnlineSearch";//搜索
    public static final String ShopSnapUpMyRecord = "shopSnapUpMyRecord";//抢疯了——个人兑换记录
    public static final String VideoSeachHot = "videoSeachHot";//在线视频——热门搜索
    public static final String ApkSeachHot = "apkSeachHot";//在线视频——热门搜索

    public static final String VideoSeach = "videoSeach";//在线视频——搜索
    public static final String ApkSeach = "apkSeach";//apk搜索
    public static final String KeyVaule = "keyVaule";//在线视频——关键字
    public static final String CodeRegister = "codeRegister";//用户注册
    public static final String CodeUpdate = "codeUpdate";//修改密码
    public static final String IdentifyingCodeCheck = "identifyingCodeCheck";//校验验证码
    public static final String ShopSnapUpClick = "shopSnapUpClick";//抢疯了--个人抢中记录--点击领取

    public static final String SortKey = "sortKey";//排序方式（1发货，2领取）
    public static final String SortStyle = "sortStyle";//排序顺序（asc 升序,desc 降序）
    ///////////////亿众淘////////////
    public static final String TaoFirst = "taoFirst";//亿众淘首页
    public static final String TaoThreeModule = "taoThreeModule";//亿众淘3个模块商品列表
    public static final String TaoTypeNew = "taoTypeNew";//十个分类模块
    public static final String TaoModuleNew = "taoModuleNew";//十个分类模块
    public static final String Side = "side";//位置(1.9块9   2.20元封顶  3.特价好货)
    public static final String ProductDetails = "productDetails";//商品详情
    public static final String ProductDetailsNew = "productDetailsNew";//商品详情
    public static final String ProductDetailsUrl = "productDetailsUrl";//商品详情
    public static final String TypeTitle = "typeTitle";//分类名称
    public static final String IsSort = "isSort";//排序
    public static final String TaoType = "taoType";//分类数据
    public static final String TaoSearch = "taoSearch";//亿众淘搜索
    public static final String TaoSearchNew = "taoSearchNew";//亿众淘搜索
    public static final String TaoFlashSale = "taoFlashSale";//亿众淘限时抢购

    public static final String MyAllRefer = "myAllRefer";//【购物记录】--确定下单
    public static final String MyAllSure = "myAllSure";//【购物记录】--确定结算
    ///////////////金币专属////////////


    public static final String GoldList = "goldList";//金币专属首页

    public static final String ActivityDelGold = "activityDelGold";//摇一摇和刮刮乐扣去金币键值


    public static final String GetCode = "getCode";//更换手机——旧手机获取验证码
    public static final String OldVerify = "oldVerify";//更换手机——旧手机获取验证码
    public static final String CheckCode = "checkCode";//更换手机——旧手机验证验证码
    public static final String Verify = "verify";//更换手机——验证码
    public static final String NewVerify = "newVerify";//更换手机——新手机获取验证码
//    public static final String ShopSnapUpMyRecord = "shopSnapUpMyRecord";

    //实名认证
    public static String Cardno = "cardno";
    public static String Realname = "realname";

    public static final String UserName = "userName";//用户昵称
    public static final String UserSex = "userSex";//性别
    public static final String UserInfo = "userInfo";//个人简介
    public static final String UserBirthday = "userBirthday";//生日
    public static final String UserEmail = "userEmail";//邮箱
    public static final String UserSchool = "userSchool";//学校
    public static final String UserCompany = "userCompany";//公司
    public static final String UserHometown = "userHometown";//故乡
    public static final String UserAddress = "userAddress";//地址
    //    public static final String ScratchCard = "scratchCard";//刮刮乐点击玩，开始刮奖
    public static final String ScratchCardNew = "scratchCardNew";//刮刮乐点击玩，开始刮奖
    public static final String ScratchCardList = "scratchCardList";//获取刮刮信息刮刮乐点击玩，开始刮奖

    public static final String ScratchCardResult = "scratchCardResult";//刮中点击领取

    public static final String PhoneCheckIdentity = "phoneCheckIdentity";//找回支付密码身份认证
    public static final String IdCard = "idcard";
    public static final String CodePaySet = "codePaySet";//初始设置支付密码codePaySet
    public static final String PhoneForgetNewPayPass = "phoneForgetNewPayPass";//忘记支付密码——重新设置新密码
    public static final String VideoNearby = "videoNearby";//在线视频——附近的

    public static final String GetRechargeUrl = "getRechargeUrl";//充值中心

    public static final String GameEnterTime = "gameEnterTime";//游戏中心是否第一次进入

    public static final String GameOnline = "gameOnline";//游戏网游是否第一次进入
    public static final String GameStand = "gameStand";//游戏单机是否第一次进入
    public static final String GameRecharge = "gameRecharge";//充值是否第一次进入

    public static final String GoldExclusiveBig = "goldExclusivebig";//金币专属
    public static final String GameExclusiveBig = "gameExclusivebig";//游戏

    public static final String GoldExclusive = "goldExclusive";//金币专属


    ////////////银行卡///////////

    public static final String DelBankCard = "delBankCard";//删除银行卡
    public static final String SelectBankCard = "selectBankCard";//获取银行卡
    public static final String CheckBankCard = "checkBankCard";//短信验证
    public static final String IdentifyingCode = "identifyingCode";//验证预留手机号码
    public static final String AddBankCard = "addBankCard";//添加银行卡
    public static final String IsReal = "isReal";//判断是否验证、2017/3/27已经抛弃，改成 isRealNew
    public static final String isRealNew = "isRealNew";//判断是否验证
    public static final String GetRealAuthentication = "getRealAuthentication";//身份证验证
    public static final String GetReal = "getReal";//实名认证接口
    public static final String IsOverstep = "isOverstep";//是否超过60秒
    public static final String CodeCheckBank = "codeCheckBank";//验证银行预留手机号码
    public static final String UseSimpleInfo = "useSimpleInfo";//获取用户认证姓名接口


    public static final String BankId = "bankId";

    public static final String CardNum = "cardNum";

    public static final String CardPhone = "cardPhone";
    public static final String SystemActivity = "systemActivity";
    public static final String ActivityCollect = "activityCollect";
    public static final String Ids = "ids";//精彩活动我的收藏id拼接
//    public static final String PayPass = "payPass";//实名认证接口
//    public static final String GetReal = "getReal";//实名认证接口


    public static final String ProductRemainDay = "productRemainDay";
    public static final String GetAlipayKey = "getAlipayKey";//获取支付宝信息
    public static final String GetWeiXinKey = "getWeiXinKey";//获取微信信息
    public static final String WeixinAuthorize = "weixinAuthorize";//获取微信信息
    public static final String AuthorizeCode = "authorizeCode";//获取登录验证码
    public static final String WeixinCode = "weixinCode";//微信验证码
    public static final String WeixinAuthorizeCheck = "weixinAuthorizeCheck";//微信登录
    public static final String AlipayAuthorize = "alipayAuthorize";//支付宝授权登录
    public static final String AlipayAuthorizeCheck = "alipayAuthorizeCheck";//支付宝登录
    public static final String AlipayCode = "alipayCode";//支付宝验证码
    public static final String Auth_Code = "auth_code";//支付宝auth_code
    public static final String Alipay_Open_Id = "alipay_open_id";//支付宝alipay_open_id
    public static final String OpenId = "openid";//支付宝openid既：userId
    public static final String Token = "token";//获取微信信息token
    public static final String Country = "country";//获取微信信息country
    public static final String Unionid = "unionid";//获取微信信息unionid
    public static final String Nickname = "nickname";//获取微信信息nickname
    public static final String Sex = "sex";//获取微信信息sex
    public static final String Headimgurl = "headimgurl";//获取微信信息headimgurl
    public static final String Privilege = "privilege";//获取微信信息privilege
    public static final String TaobaoAuthorize = "taobaoAuthorize";//淘宝taobaoAuthorize
    public static final String Nick = "nick";//淘宝nick
    public static final String AvatarUrl = "avatarUrl";//淘宝avatarUrl
    public static final String OpenSid = "openSid";//淘宝openSid
    public static final String TaobaoCode = "taobaoCode";//淘宝验证码类型TaobaoCode
    public static final String TaobaoAuthorizeCheck = "taobaoAuthorizeCheck";//淘宝taobaoAuthorizeCheck

    public static final String MyNovelRecore = "myNovelRecore";//小说主页
    public static final String NovelSeachHot = "novelSeachHot";//小说搜索
    public static final String NovelSeach = "novelSeach";//小说搜索

    ///////////////小说简介////////////
    public static final String NovelGetChapter = "novelGetChapter";//获取小说章节
    public static final String BookId = "bookId";//小说id
    public static final String BookPosition = "position";//小说位置
    public static final String BookCollect = "isCollect";//是否收藏
    public static final String ChapterId = "chapterId";//小说章节id
    public static final String ChapterList = "chapterList";//小说章节id
    public static final String NextChapterId = "nextChapterId";//小说章节id
    public static final String BuyId = "buyId";//购买小说章节id
    public static final String NovelGetInfo = "novelGetInfo";//获取小说详情介绍
    public static final String Noveladd = "noveladd";//加入书架
    public static final String NovelGetChapterText = "novelGetChapterText";//获取小说内容

    public static final String NovelDel = "novelDel";//删除小说


    ///////////////小说更多精品、免费////////////
    public static final String IndexTypeList = "indexTypeList";//小说更多精品
    public static final String TypeStyle = "typeStyle";//小说更多精品
    public static final String NovelStand = "novelStand";//小说更多精品
    public static final String NovelBuyRepay = "novelBuyRepay";//购买小说
    ///////////////谁买单////////////
    public static final String Room = "room";//获取房间
    public static final String DoRoom = "doRoom";//打开房间
    public static final String RoomNum = "roomNum";//房间号码
    public static final String LeaveRoom = "LeaveRoom";//离开房间
    public static final String SelectGame = "selectGame";//游戏列表
    public static final String GameStart = "gameStart";//开始游戏
    public static final String GameId = "gameId";//gameId
    public static final String NovelStoreWindow = "novelStoreWindow";//小说书城弹窗
    public static final String HousePwd = "housePwd";//房间密码(可为空)
    public static final String WifiRoom = "wifiRoom";//创建房间
    public static final String InRoom = "inRoom";//进入房间
    public static final String PreRoom = "preRoom";//以前的房间
    public static final String SearchRoom = "searchRoom";//搜索单个房间号
    public static final String GameSelect = "gameSelect";//选择游戏

    ///////////////新版亿众淘////////////
    public static final String TaoFirstIndex = "taoFirstIndex";//亿众淘首页
    public static final String SearchHot = "seachHot";//亿众淘首页
    public static final String PoductCouponsValue = "productCouponsValue";//优惠券面值
    public static final String ProductFrom = "productFrom";//    商品专题类型【默认空】
    public static final String SeachHotKey = "seachHotKey";//亿众淘搜索相似关键词

    public static final String Condition = "condition";//排序条件（0价格从高到底，1价格从低到高，2销量优先，3按照人气，4包邮，5价格区间,6天猫旗舰店，7聚划算，8天猫）
    public static final String StarPrice = "starPrice";//起始价格【价格区间时传值】
    public static final String EndPrice = "endPrice";// 结束价格【价格区间时传值】

    //查询客服
    public static final String RobotService = "robotService";
    public static final String RobotServiceDetails = "robotServiceDetails";
    public static final String Title = "title";

    ///////////////我的电话////////////
    public static final String ChatSetStatus="chatSetStatus";//午夜畅聊
    public static final String ChatUseInfoEdit="chatUseInfoEdit";//午夜畅聊-个人信息编辑提交
    public static final String ChatUseInfo="chatUseInfo";//午夜畅聊-个人信息获取
    public static final String ChatOut="chatOut";//午夜畅聊-离开聊天室
    public static final String AccountInfo = "accountInfo";//获取账户信息（金币，时长）
    public static final String StartCall = "startCall";//回拨接口
    public static final String EndCall = "endCall";//通话结束结算接口
    public static final String Tophone = "tophone";
    public static final String ShowImgCall = "showImgCall";//来电秀秀图片获取
    public static final String ChatSet = "chatSet";//午夜畅聊-设置开关
    public static final String ChatIng = "chatIng";//午夜畅聊-咻一咻
    public static final String ChatSendGold = "chatSendGold";//午夜畅聊-送对方金币
    public static final String UserId = "userId";//午夜畅聊-被叫方id
    public static final String Gold = "gold";//午夜畅聊-赠送的金币
    public static final String ReceiveCard = "receiveCard";//拨打达标点击领取补签卡
    ///////////////流量充值////////////
    public static final String CurrentItem = "currentItem";//选中的充值类型
    /////////////// 幸运摇奖-收货信息////////////
    public static final String ReceivInformaBean="receivInformaBean";


    //商品分类
    public static final String AllProductType = "allProductType";
}
