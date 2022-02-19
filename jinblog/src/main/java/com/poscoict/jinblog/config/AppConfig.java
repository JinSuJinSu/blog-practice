package com.poscoict.jinblog.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.poscoict.config.app.DBConfig;
import com.poscoict.config.app.MyBatisConfig;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.poscoict.jinblog.service","com.poscoict.jinblog.repository"})
@Import({DBConfig.class, MyBatisConfig.class})
public class AppConfig {
	
}
