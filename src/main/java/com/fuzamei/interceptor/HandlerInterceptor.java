package com.fuzamei.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fuzamei on 2018/8/28.
 */
@Slf4j
@Component
public class HandlerInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            log.info("当前拦截的方法为：{}",handlerMethod.getMethod().getName());
            log.info("当前拦截的方法参数长度为：{}",handlerMethod.getMethod().getParameters().length);
            log.info("当前拦截的方法为：{}",handlerMethod.getBean().getClass().getName());
            System.out.println("开始拦截---------");
            String uri = request.getRequestURI();
            System.out.println("拦截的uri："+uri);
        }
        return true;

    }

}