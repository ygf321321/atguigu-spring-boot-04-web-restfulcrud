package com.atguigu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@SpringBootApplication
public class AtguiguSpringBoot04WebRestfulcrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtguiguSpringBoot04WebRestfulcrudApplication.class, args);
	}

	public ViewResolver myViewResolver(){
		return  new MyViewResolver();
	}
	private static  class  MyViewResolver implements ViewResolver{

		@Override
		public View resolveViewName(String viewName, Locale locale) throws Exception {
			return null;
		}
	}
}
