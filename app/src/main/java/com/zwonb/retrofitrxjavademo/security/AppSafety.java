package com.zwonb.retrofitrxjavademo.security;

import android.annotation.SuppressLint;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import okhttp3.Request;

/**
 * Created by li4236 on 2017/1/5.
 * 项目加密工具
 */

public class AppSafety {


    /**
     * 获取系统时间
     */
    @SuppressLint("SimpleDateFormat")
    public static String getTime() {

        // 获取系统时间
        Date now = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");// 可以方便地修改日期格式

        String time = dateFormat.format(now);

        return time;

    }

    public static String getKey(String time) {

        SafetyEncryption mEncryption = new SafetyEncryption();

        return mEncryption.swap(mEncryption.encodeBase64(time));

    }

    public static String getClueid(String mtime) {

        SafetyEncryption mEncryption = new SafetyEncryption();

        return mEncryption.md5(HttpConfig.HTTP_HEADER_KEY + mtime);

    }

    /**
     * @param data
     * @return 添加验证
     */
    public static String getVerify(Map<String, Object> map, String data, Request original) {
        try {


            String hash = getVerify(data);

            printlnLog(map, hash, original);
            return hash;


        } catch (Exception e) {
            String error = e.getMessage();
//            ComLog.D(error + "");
//            System.out.println("Error");
            return null;
        }
    }

    /**
     * @param data
     * @return 添加验证
     */
    public static String getVerify(String data) {
        try {

            data = data.replace('+', ' ');

            String message = URLEncoder.encode(data, "utf-8");

            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");

            SecretKeySpec secret_key = new SecretKeySpec(HttpConfig.HTTP_KEY.getBytes(), "HmacSHA256");

            sha256_HMAC.init(secret_key);

            String hash = SafetyThreeDes.Base64.encode(sha256_HMAC.doFinal(message.getBytes()));
            return hash;


        } catch (Exception e) {
            String error = e.getMessage();
//            ComLog.D(error + "");
//            System.out.println("Error");
            return null;
        }
    }


    public static String getParams(Map<String, Object> map, Request original) {

        String verify = "";

        if (null != map) {


            Object[] key_arr = map.keySet().toArray();
            Arrays.sort(key_arr);
            for (Object key : key_arr) {

                verify = verify + key + "=" + map.get(key) + "&";

            }

        }
        return getVerify(map, verify.substring(0, verify.length() - 1), original);
    }


    /**
     * @param map
     * @param mVerify 打印调试参数
     */
    public static void printlnLog(Map<String, Object> map, String mVerify, Request original) {

//        if (ComLog.LOG) {
//
//            Map<String, Object> hashMap = new ArrayMap<>();
//
//            hashMap.putAll(map);
//            hashMap.put(AlActValue.ACCESSSIGN, mVerify);
//
//
//            Object[] key_arr = hashMap.keySet().toArray();
//            Arrays.sort(key_arr);
//
//            StringBuilder sb = new StringBuilder();
//            sb.append("\n----------start---------\n");
//            sb.append("\n" + original.toString() + "\n");
//            for (Object key : key_arr) {
//
//                sb.append("【 " + key + " == " + hashMap.get(key) + " 】\n");
//
//            }
//
//            sb.append("\n----------end---------\n");
//            sb.delete(sb.length() - 1, sb.length());
////            mMessage = mMessage.substring(0, mMessage.length() - 1);
//
//            ComLog.println(sb.toString());
//        }
    }

}
