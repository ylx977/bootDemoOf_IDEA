package com.fuzamei.bean;

import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by fuzamei on 2018/4/3.
 */
@Component
public class ConfigLoadListener implements ServletContextListener{

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {

    }
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("++++++++++++++++++++++++++++++平台初始化（测试版本）"+"++++++++++++++++++++++++++++++");
    }
}
