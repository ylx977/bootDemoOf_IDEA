package com.fuzamei.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by fuzamei on 2018/4/5.
 */
@WebFilter(urlPatterns = "/*")
public class CustomFilter2 implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("这是另外一个过滤器");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
