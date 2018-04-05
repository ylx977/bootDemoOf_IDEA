package com.fuzamei.config.filter;

import com.fuzamei.filter.CustomFilter;
import com.fuzamei.filter.CustomFilter2;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * Created by fuzamei on 2018/4/5.
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean filterRegister(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new CustomFilter());
//        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(1);//spring boot 会按照order值的大小，从小到大的顺序来依次过滤1,先执行，2后执行。
        return filterRegistrationBean;
    }

    @Bean
    @Order(value = 2)//也可以通过注解的方式设置过滤器的顺序
    public FilterRegistrationBean filterRegister2(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new CustomFilter2());
//        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

}
