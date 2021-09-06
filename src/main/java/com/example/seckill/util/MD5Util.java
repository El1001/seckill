package com.example.seckill.util;

import org.springframework.stereotype.Component;
import org.apache.commons.codec.digest.DigestUtils;
/**
 * MD5工具类
 *
 * @author admin
 * @date 2021年 09月06日 15:13:10
 */
@Component
public class MD5Util {
    public static String md5(String src) {
        return  DigestUtils.md5Hex(src);
    }
    private static final String salt = "1a2b3c4d";

    public static String inputPassToFormPass(String inputPass) {
        String s = "" + salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
        return md5(s);
    }
    public static String formPassToDBPass(String formPass, String salt) {
        String s = "" + salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(5) + salt.charAt(4);
        return md5(s);
    }

    public static String inputPassToDBPass(String inputPass, String slatDB) {
        String fromPass = inputPassToFormPass(inputPass);
        String dbPass = formPassToDBPass(fromPass, slatDB);
        return dbPass;
    }
// test
    public static void main(String[] args) {
        System.out.println(inputPassToFormPass("123456"));
        System.out.println(formPassToDBPass(inputPassToFormPass("123456"),"1a2b3c4d"));
        System.out.println(inputPassToDBPass("123456","1a2b3c4d"));
    }

}
