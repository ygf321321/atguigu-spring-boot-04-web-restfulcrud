package com.atguigu.springboot.config;

import com.atguigu.springboot.component.LoginHandlerIntercepter;
import com.atguigu.springboot.component.MyLocaleResolver;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;


//@EnableWebMvc　全面接管，所有ｓｐｒｉｎｇｍｖｃ自动配置失效　
//使用WebMvcConfigurerAdapter 　应该已废弃，可用接口　可以来扩展SpringMVC的功能
@Configuration
public class MyMvcConfig  implements WebMvcConfigurer {

   public void addViewControllers(ViewControllerRegistry registry) {
//       浏览器发请求　／atguigu 请求来到success
       registry.addViewController("/atguigu").setViewName("guigu");
    }

    @Bean
    public WebMvcConfigurerAdapter webMvcAutoConfigurationAdapter(){
       WebMvcConfigurerAdapter adapter= new WebMvcConfigurerAdapter() {

           @Override
           public void addViewControllers(ViewControllerRegistry registry) {
//               super.addViewControllers(registry);
               registry.addViewController("/").setViewName("login");
               registry.addViewController("/index.html").setViewName("login");
               registry.addViewController("/main.html").setViewName("dashboard");
           }
           //注册拦截器
           @Override
           public void addInterceptors(InterceptorRegistry registry) {
//               super.addInterceptors(registry);
               //拦截所有请求，排除登录页面 /   登录验证请求
               //SpringBoot已经做好了静态资源映射， *.css *.js
               registry.addInterceptor(new LoginHandlerIntercepter()).addPathPatterns("/**")
                       .excludePathPatterns("/index.html","/","/user/login");
           }

       };
       return adapter;
    }

    @Bean
    public LocaleResolver localeResolver(){
       return  new MyLocaleResolver();
    }
}
