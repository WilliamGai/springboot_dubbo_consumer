package com.williamy.dubbo;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
/**
 * Reference会作为消费者寻找远程服务
 * 说明：
 * @Reference(version="1.0.0", check=false, init=false)
 * check和init请使用默认值,init是默认值false的时候只有再需要的时候才会注入,因此也用默认值就好
 */
@Service
public class DubboServiceHandler {
	//消费者
	@Reference(version="1.0.0")
	public
	IHelloDubboService helloservice;
}
