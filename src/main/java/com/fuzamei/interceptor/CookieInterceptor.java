package com.fuzamei.interceptor;

import com.fuzamei.utils.CookieUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fuzamei on 2018/9/17.
 */
@Component
public class CookieInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        CookieUtil.writeCookie(response,"name","jack");
        CookieUtil.writeCookie(response,"age","19");
        CookieUtil.writeCookie(response,"address","hangzhou");
        CookieUtil.writeCookie(response,"sex","male");
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        super.postHandle(request, response, handler, modelAndView);
    }
}
