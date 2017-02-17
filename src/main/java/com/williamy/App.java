package com.williamy;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.williamy.dubbo.IHelloDubboService;
import com.williamy.dubbo.DubboServiceHandler;

@Controller
@SpringBootApplication
public class App {

	@Autowired
	DubboServiceHandler testService;
	
	@Reference(version="1.0.0")
	IHelloDubboService helloservice;
	
	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello dubbo consumer!"+helloservice.sayHello();
	}
	@RequestMapping("/a")
	@ResponseBody
	String a() {
		return "Hello dubbo consumer a!"+testService.helloservice;
	}
	@RequestMapping("/hello")
	@ResponseBody
	String testDubboDemo() {
		return this.hashCode()+"Hello dubbo consumer a!"+testService.helloservice.sayHello();
	}
	public static void main(String[] args) throws Exception {
		LogCore.BASE.info("app started={}",  Arrays.toString(args));
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
		LogCore.BASE.info("app all services={}",(context.getBeansWithAnnotation(Service.class)));
		LogCore.BASE.info("app all referens={}",(context.getBeansWithAnnotation(Reference.class)));
	}

}
