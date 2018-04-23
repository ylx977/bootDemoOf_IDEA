package com.fuzamei.config.interceptor;


import com.fuzamei.interceptor.OtherInterceptor;
import com.fuzamei.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by fuzamei on 2018/4/5.
 */
@Configuration
public class InteceptorConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TokenInterceptor()).addPathPatterns("/hello").excludePathPatterns("test").order(1);
        registry.addInterceptor(new OtherInterceptor()).addPathPatterns("/hello").order(2);//可以配置多个拦截器，order从小到大依次执行
    }

    @Bean//解决中文乱码的StringHttpMessageConverter
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        return converter;
    }

    @Override//将上面的StringHttpMessageConverter加入到boot默认的HttpMessageConverter集合中
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(responseBodyConverter());
    }

//    @Override这个似乎没用
//    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//        configurer.favorPathExtension(false);
//    }

    //=================================

}
