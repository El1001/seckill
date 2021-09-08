package com.example.seckill.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Json 工具类
 *
 * @author admin
 * @date 2021年 09月08日 16:17:08
 */
public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 将对象转化为json 字符串
     * @param obj
     * @return
     */
    public static String object2JsonStr(Object obj){
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 字符串转化层对象
     * @param jsonStr
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T jsonStr2Object(String jsonStr, Class<T> clazz) {
        try {
            return objectMapper.readValue(jsonStr.getBytes(StandardCharsets.UTF_8),clazz);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * json 转化为 pojo 对象的list
     * @param jsonStr
     * @param beantype
     * @param <T>
     * @return
     */
    public static <T> List<T> jsonToList(String jsonStr, Class<T> beantype) {
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, beantype);
        try {
            List<T> list = objectMapper.readValue(jsonStr,javaType);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
