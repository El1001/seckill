package com.example.seckill.util;

import java.util.UUID;

/**
 * UUID工具
 *
 * @author admin
 * @date 2021年 09月07日 17:08:41
 */
public class UUIDUtil {
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-","");
    }
}
