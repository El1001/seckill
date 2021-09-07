package com.example.seckill.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * CookieUtil 工具类
 *
 * @author admin
 * @date 2021年 09月07日 16:25:51
 */
public class CookieUtil {
    /**
     * cookie的值获得，不编码
     *
     * @param request
     * @param cookieName
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String cookieName) {
        return getCookieValue(request, cookieName, false);
    }

    /**
     * 获得cookies的值
     *
     * @param request
     * @param cookieName
     * @param idDecoder
     * @return
     */
    private static String getCookieValue(HttpServletRequest request, String cookieName, boolean idDecoder) {
        Cookie[] cookies = request.getCookies();
        if (null == cookies || null == cookieName) {
            return null;
        }
        String retValue = null;
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals(cookieName)) {
                if (idDecoder) {
                    try {
                        retValue = URLDecoder.decode(cookies[i].getValue(), "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                } else {
                    retValue = cookies[i].getValue();
                }
                break;
            }
        }
        return retValue;
    }

    /**
     *  得到cookies 的值
     * @param request
     * @param cookieName
     * @param encodeString
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String
            cookieName, String encodeString) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookieName == null) {
            return null;
        }
        String retValue = null;
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals(cookieName)) {
                try {
                    retValue = URLDecoder.decode(cookies[i].getValue(), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        return retValue;
    }

    /**
     * 设置Cookie的值 不设置生效时间默认浏览器关闭即失效,也不编码
     * @param request
     * @param response
     * @param cookieName
     * @param cookieValue
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String cookieValue) {
        setCookie(request,response,cookieName,cookieValue,-1);
    }

    /**
     *设置Cookie的值 在指定时间内生效,但不编码
     * @param request
     * @param response
     * @param cookieName
     * @param cookieValue
     * @param cookieMaxage
     */
    private static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
                                  String cookieValue, int cookieMaxage) {
        setCookie(request,response,cookieName,cookieValue,cookieMaxage,false);

    }

    /**
     * 设置Cookie的值 不设置生效时间,但编码
     * @param request
     * @param response
     * @param cookieName
     * @param cookieValue
     * @param isEncode
     */
    private static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, 
                                  String cookieValue, boolean isEncode) {
        setCookie(request,response,cookieName,cookieValue,-1,isEncode);
    }

    /**
     *  设置Cookie的值 在指定时间内生效, 编码参数
     * @param request
     * @param response
     * @param cookieName
     * @param cookieValue
     * @param cookieMaxage
     * @param isEncode
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, 
                                 String cookieValue, int cookieMaxage, boolean isEncode) {
        doSetCookie(request, response, cookieName, cookieValue, cookieMaxage, isEncode);
    }

    /**
     * 设置Cookie的值 在指定时间内生效, 编码参数(指定编码)
     * @param request
     * @param response
     * @param cookieName
     * @param cookieValue
     * @param cookieMaxage
     * @param encodeString
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response,
                                 String cookieName, String cookieValue, int cookieMaxage, String encodeString) {
        doSetCookie(request, response, cookieName, cookieValue, cookieMaxage, encodeString);
    }

    /**
     * 删除Cookie带cookie域名
     * @param request
     * @param response
     * @param cookieName
     */
    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String cookieName) {
        doSetCookie(request, response, cookieName, "", -1, false);
    }

    /**
     * 设置Cookie的值，并使其在指定时间内生效
     *
     * @param cookieMaxage cookie生效的最大秒数
     */
    private static final void doSetCookie(HttpServletRequest request, HttpServletResponse response,
                                          String cookieName, String cookieValue, int cookieMaxage, boolean isEncode) {
        try {
            if (cookieValue == null) {
                cookieValue = "";
            } else if (isEncode) {
                cookieValue = URLEncoder.encode(cookieValue, "utf-8");
            }
            Cookie cookie = new Cookie(cookieName, cookieValue);
            if (cookieMaxage > 0)
                cookie.setMaxAge(cookieMaxage);
            if (null != request) {// 设置域名的cookie
                String domainName = getDomainName(request);
                System.out.println(domainName);
                if (!"localhost".equals(domainName)) {
                    cookie.setDomain(domainName);
                }
            }cookie.setPath("/");
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置Cookie的值，并使其在指定时间内生效
     *
     * @param cookieMaxage cookie生效的最大秒数
     */
    private static final void doSetCookie(HttpServletRequest request,
                                          HttpServletResponse response,
                                          String cookieName, String cookieValue,
                                          int cookieMaxage, String encodeString) {
        try {
            if (cookieValue == null) {
                cookieValue = "";
            } else {
                cookieValue = URLEncoder.encode(cookieValue, encodeString);
            }
            Cookie cookie = new Cookie(cookieName, cookieValue);
            if (cookieMaxage > 0) {
                cookie.setMaxAge(cookieMaxage);
            }
            if (null != request) {// 设置域名的cookie
                String domainName = getDomainName(request);
                System.out.println(domainName);
                if (!"localhost".equals(domainName)) {
                    cookie.setDomain(domainName);
                }
            }
            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 得到cookie的域名
     */
    private static final String getDomainName(HttpServletRequest request) {
        String domainName = null;
        // 通过request对象获取访问的url地址
        String serverName = request.getRequestURL().toString();
        if (serverName == null || serverName.equals("")) {
            domainName = "";
        } else {
        // 将url地下转换为小写
            serverName = serverName.toLowerCase();
        // 如果url地址是以http://开头 将http://截取
            if (serverName.startsWith("http://")) {
                serverName = serverName.substring(7);
            }
            int end = serverName.length();
        // 判断url地址是否包含"/"
            if (serverName.contains("/")) {
        //得到第一个"/"出现的位置
                end = serverName.indexOf("/");
            }
        // 截取
            serverName = serverName.substring(0, end);
        // 根据"."进行分割
            final String[] domains = serverName.split("\\.");
            int len = domains.length;
            if (len > 3) {
        // www.xxx.com.cn
                domainName = domains[len - 3] + "." + domains[len - 2] + "." +
                        domains[len - 1];
            } else if (len <= 3 && len > 1) {
        // xxx.com or xxx.cn
                domainName = domains[len - 2] + "." + domains[len - 1];
            } else {
                domainName = serverName;
            }
        }
        if (domainName != null && domainName.indexOf(":") > 0) {
            String[] ary = domainName.split("\\:");
            domainName = ary[0];
        }
        return domainName;
    }
}
