package com.fuzamei.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by fuzamei on 2018/8/30.
 */
@Component
public class TestServiceFactory implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    private static Map<String,TestService> repository = new ConcurrentHashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        TestServiceFactory.applicationContext = applicationContext;
    }

    @PostConstruct
    public void injectRepository(){
        System.out.println("开始启动的时候做的事情");
        Map<String, TestService> beansOfType = applicationContext.getBeansOfType(TestService.class);
        beansOfType.forEach((x,y)-> System.err.println("key："+x+"---->"+y));
    }
}
