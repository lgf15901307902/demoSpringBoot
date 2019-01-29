package net.xdclass.demo.intecpter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class CustomWebMvcConfigurer  {
    
	@Autowired
    private	LoginIntercepter loginIntercepter;
	//增加拦截器
     public void addInterceptors(InterceptorRegistry registry){
         registry.addInterceptor(loginIntercepter)    //指定拦截器类
                .addPathPatterns("/Handles");        //指定该类拦截的url
     }
	


}
