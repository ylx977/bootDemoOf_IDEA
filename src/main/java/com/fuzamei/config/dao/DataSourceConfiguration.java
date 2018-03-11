package com.fuzamei.config.dao;

import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by fuzamei on 2018/3/11.
 */
@Configuration//告诉spring来这个类下面检索相关的bean
@MapperScan("com.fuzamei.dao")//配置mybatis mapper的扫描路径
public class DataSourceConfiguration {

    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUsername;
    @Value("${jdbc.password}")
    private String jdbcPassword;
    @Value("${jdbc.connectionTimeout}")
    private Long jdbcConnectionTimeout;
    @Value("${jdbc.idleTimeout}")
    private Long jdbcIdleTimeout;
    @Value("${jdbc.maxLifetime}")
    private Long jdbcMaxLifetime;
    @Value("${jdbc.maximumPoolSize}")
    private Integer jdbcMaximumPoolSize;
    @Value("${jdbc.minimumIdle}")
    private Integer jdbcMinimumIdle;

    @Bean(name = "datasource")
    public HikariDataSource createDataSource(){
        HikariDataSource datasource = new HikariDataSource();
        datasource.setDriverClassName(jdbcDriver);
        datasource.setJdbcUrl(jdbcUrl);
        datasource.setUsername(jdbcUsername);
        datasource.setPassword(jdbcPassword);
        datasource.setReadOnly(false);
        datasource.setConnectionTimeout(jdbcConnectionTimeout);
        datasource.setIdleTimeout(jdbcIdleTimeout);
        datasource.setMaxLifetime(jdbcMaxLifetime);
        datasource.setMaximumPoolSize(jdbcMaximumPoolSize);
        datasource.setMinimumIdle(jdbcMinimumIdle);
        datasource.setAutoCommit(false);
        return datasource;
    }
}
