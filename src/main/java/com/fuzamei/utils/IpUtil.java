package com.fuzamei.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ylx
 * Created by fuzamei on 2018/4/15.
 */
public class IpUtil {

     public static final String getIpAddress(HttpServletRequest request) {
         String ip = request.getHeader("x-forwarded-for");
         System.out.println("x-forwarded-for:" + ip);
         ip = request.getHeader("Proxy-Client-IP");
         System.out.println("Proxy-Client-IP:" + ip);
         ip = request.getHeader("WL-Proxy-Client-IP");
         System.out.println("WL-Proxy-Client-IP:" + ip);
         ip = request.getHeader("HTTP_CLIENT_IP");
         System.out.println("HTTP_CLIENT_IP:" + ip);
         ip = request.getHeader("HTTP_X_FORWARDED_FOR");
         System.out.println("HTTP_X_FORWARDED_FOR:" + ip);
         ip = request.getHeader("X-Real-IP");
         System.out.println("X-Real-IP:" + ip);
         ip = request.getRemoteAddr();
         System.out.println("remote:" + ip);
         return ip;
     }
}
