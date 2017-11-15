package com.zwonb.retrofitrxjavademo.security;


import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * 加密安全
 */
public class SafetyEncryption {

    // url用的加密
    public String encryption(String url, String key) throws Exception {

        return swap(encodeBase64(ascii(url, key)));
    }

    // 把字符转为对应ascii数值
    public String ascii(String url, String key) {

        String end = "";

        char[] url_chars = url.toCharArray();

        char[] key_chars = key.toCharArray();

        int u = url_chars.length;

        int k = key_chars.length;

        int x = 0;

        for (int i = 0; i < u; i++) {
            // 使key读到尾部时从头读取
            if (x == k) {
                x = 0;
            }
//			WeiLog.e(url_chars[i]);
//			WeiLog.e((int)url_chars[i]);
            int sss = ((int) url_chars[i] + (int) (key_chars[x])) * 2 + 1;// 转AS并*2+1
            end = end + ("" + sss + ",");
            x++;
        }
        return end;

    }

    /**
     * @param plainText 明文
     * @return 32位密文
     */
    public String md5(String plainText) {

        String re_md5 = new String();

        try {

            MessageDigest md = MessageDigest.getInstance("MD5");

            md.update(plainText.getBytes());

            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");

            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }

            re_md5 = buf.toString();

        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
        }
        return re_md5;
    }

    /**
     * @param plainText 明文
     * @return 错位密文
     */
    public String swap(String plainText) {
        plainText = plainText.substring(plainText.length() - 4,
                plainText.length())
                + plainText.substring(4, plainText.length() - 4)
                + plainText.substring(0, 4);
        return plainText;
    }

    //	/**
//	 *
//	 * @param plainText
//	 *            明文
//	 * @return base64密文
//	 */
    public String encodeBase64(String plainText) {
        byte[] b = plainText.getBytes();
        Base64 base64 = new Base64();
        b = base64.encode(b);
        String s = new String(b).replaceAll("=", "");
        return s;
    }
}
