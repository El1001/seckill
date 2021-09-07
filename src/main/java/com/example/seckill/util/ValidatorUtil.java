package com.example.seckill.util;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字段校验工具 正则校验吧
 *
 * @author admin
 * @date 2021年 09月07日 12:02:19
 */
public class ValidatorUtil {
    /**
     * 校验手机格式
     */
    private static final Pattern mobile_pattern = Pattern.compile("[1]([3-9])[0-9]{9}$");

    public static boolean isMobile(String mobile) {
        if (StringUtils.isEmpty(mobile)) {
            return false;
        }
        Matcher matcher = mobile_pattern.matcher(mobile);
        return matcher.matches();
    }
}
