package com.poscoict.jinblog.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.poscoict.config.web.FileuploadConfig;
import com.poscoict.config.web.MVCConfig;



@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.poscoict.jinblog.controller"})
@Import({MVCConfig.class, FileuploadConfig.class})
public class WebConfig extends WebMvcConfigurerAdapter{

}
