package com.fuzamei.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by fuzamei on 2018/4/5.
 */
@WebFilter(urlPatterns = "/*")//也可以不要@WebFilter(urlPatterns = "/*")这个注解，另外在Application文件或者另外建立一个配置文件进行配置就可以了。
public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("这是过滤器");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
