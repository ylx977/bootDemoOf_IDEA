package com.fuzamei.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * Created by fuzamei on 2018/9/17.
 */
public class CookieUtil {

    public static String getCookie(HttpServletRequest request,String cookieName){
        Cookie[] cookies = request.getCookies();
        if(cookies !=null && cookies.length > 0){
            for (Cookie cookie : cookies){
                if(cookie.getName().equals(cookieName)){
                    return cookie.getValue();
                }
            }
        }

        return null;
    }

    public static void writeCookie(HttpServletResponse response,String cookieName,String cookieValue){
        Cookie cookie = new Cookie(cookieName,cookieValue);
        cookie.setPath("/");
        cookie.setMaxAge(360000);
        response.addCookie(cookie);
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
