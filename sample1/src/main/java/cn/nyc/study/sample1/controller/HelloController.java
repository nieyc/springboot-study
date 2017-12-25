package cn.nyc.study.sample1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.nyc.study.db.jdbc.UserService;


@Controller
@EnableAutoConfiguration
@RequestMapping("/hello")
public class HelloController {
	
	@Value("${url}")
	private String url;
	
	@Autowired
	private UserService userSerivce;
	
	
	@RequestMapping("/test1")
	@ResponseBody
	String sayHello() {
		System.out.println("url:"+url);
		System.out.println("userSerivce:"+userSerivce);
		//userSerivce.create("zhangsan", 20);
		return "hello,world";
	}
	
	/**
	 * 出错页面，自动跳转到error.html
	 * @author nyc
	 * @date 2017年12月22日 上午10:18:06
	 * @return
	 * @throws Exception 
	 * @since 0.1
	 * @see
	 */
	@RequestMapping("/test2")
	@ResponseBody
	String sayOtherWord() throws Exception {
		throw new Exception("发生错误，雪球网");
		//return "hello,spring-boot";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HelloController.class, args);
	}
	

}
