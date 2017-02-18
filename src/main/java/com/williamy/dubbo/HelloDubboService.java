package com.williamy.dubbo;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
/* 作为生产者发布 */
@Component
@Service(version="1.0.0")
public class HelloDubboService implements IHelloDubboService {
	@Override
	public String sayHello() {
		return System.getProperty("user.dir")+System.getProperty("os.name");
	}

}