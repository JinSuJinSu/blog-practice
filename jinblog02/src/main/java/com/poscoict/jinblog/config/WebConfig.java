package com.poscoict.jinblog.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.poscoict.jinblog.security.AuthInterceptor;
import com.poscoict.jinblog.security.AuthUserHandlerMethodArgumentResolver;
import com.poscoict.jinblog.security.LoginInterceptor;
import com.poscoict.jinblog.security.LogoutInterceptor;


@SpringBootConfiguration
@PropertySource("classpath:com/poscoict/jinblog/config/webconfig.properties")
public class WebConfig implements WebMvcConfigurer {
	
	@Autowired
	private Environment env;

	//Argument Resolver
	@Bean
	public HandlerMethodArgumentResolver handlerMethodArgumentResolver() {
		return new AuthUserHandlerMethodArgumentResolver();
	}
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(handlerMethodArgumentResolver());
	}
	
//	@Bean
//	public HandlerInterceptor siteInterceptor() {
//		return new SiteInterceptor();
//	}
	
	//Interceptors
	@Bean
	public HandlerInterceptor loginInterceptor() {
		return new LoginInterceptor();
	}
	
	@Bean
	public HandlerInterceptor logoutInterceptor() {
		return new LogoutInterceptor();
	}
	
	@Bean
	public HandlerInterceptor authInterceptor() {
		return new AuthInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor()).addPathPatterns("/user/auth");
		registry.addInterceptor(logoutInterceptor()).addPathPatterns("/user/logout");
		registry.addInterceptor(authInterceptor()).addPathPatterns("/**").
		excludePathPatterns("/user/auth").excludePathPatterns("/user/logout").excludePathPatterns("/resources/**");
		
		
	}
	
	//Resource Mapping
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
			.addResourceHandler(env.getProperty("fileupload.resoueceMapping"))
			.addResourceLocations("file:" + env.getProperty("fileupload.uploadLocation"));
//		
//        registry.addResourceHandler(env.getProperty("css.resourceHandler"))
//        .addResourceLocations(env.getProperty("css.resourceLocations"));
	}
	
	
		
		
	
	

}
