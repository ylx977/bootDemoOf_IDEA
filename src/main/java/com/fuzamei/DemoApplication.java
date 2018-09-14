package com.fuzamei;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})// same as @Configuration @EnableAutoConfiguration @ComponentScan
@SpringBootApplication// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class DemoApplication {

	public static void main(String[] args) throws IOException {
//		SpringApplication.run(DemoApplication.class, args);
		SpringApplication app = new SpringApplication(DemoApplication.class);//上下两种方式一样的
		app.setBannerMode(Banner.Mode.CONSOLE);

		//可以通过以下的方法来指定默认的配置文件
//		String path = DemoApplication.class.getClassLoader().getResource("application-prod.properties").getPath();
//		Properties properties = new Properties();
//		properties.load(new FileInputStream(new File(path)));
//		app.setDefaultProperties(properties);
		app.run(args);

		//====================this is MASTER MASTER

	}
}

