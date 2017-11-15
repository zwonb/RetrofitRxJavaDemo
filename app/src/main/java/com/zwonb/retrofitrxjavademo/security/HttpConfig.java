package com.zwonb.retrofitrxjavademo.security;

/**
 * Created by li4236 on 2017/1/5.
 * 网络请求加密配置,考虑安全性
 */

public class HttpConfig {

    //url头部验证码秘钥
    public static String HTTP_HEADER_KEY = "HTTP://cswifi.yidont.com/YiDont_ELife";

    // http密钥 添加验证,最后拼接url 密码
    public static String HTTP_KEY = "Elife.yidont.comZhoushouby!23456";

    // 密钥
    public static String THREEDES_SECRETKEY = "cswifi.yidont.comZhoushouby!@#$%^&";
    // 向量
    public static String THREEDES_IV = "p0dQwifi";

}
