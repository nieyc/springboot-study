package cn.nyc.study.sample1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@EnableAutoConfiguration
@RequestMapping("/hello")
public class HelloController {
	
	@Value("${url}")
	private String url;
	
	@RequestMapping("/test1")
	@ResponseBody
	String sayHello() {
		System.out.println("url:"+url);
		return "hello,world";
	}
	
	@RequestMapping("/test2")
	@ResponseBody
	String sayOtherWord() {
		System.out.println("i wang to eat some meat");
		return "hello,spring-boot";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HelloController.class, args);
	}
	

}
