package com.williamy.dubbo;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
/**
 * Reference会作为消费者寻找远程服务
 */
@Service
public class DubboServiceHandler {
	@Reference(version="1.0.0")
	public
	IHelloDubboService helloservice;
}
