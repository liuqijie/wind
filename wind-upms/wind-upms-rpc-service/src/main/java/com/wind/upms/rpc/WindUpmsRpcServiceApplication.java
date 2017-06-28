package com.wind.upms.rpc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wind.upms.rpc.WindUpmsRpcServiceApplication;


/**
 * 服务启动类
 * Created by liuqijie on 2017/6/28.
 */
public class WindUpmsRpcServiceApplication {
	private static Logger _log = LoggerFactory.getLogger(WindUpmsRpcServiceApplication.class);

	public static void main(String[] args) {
		_log.info(">>>>> wind-upms-rpc-service 正在启动 <<<<<");
		new ClassPathXmlApplicationContext("classpath:META-INF/spring/*.xml");
		_log.info(">>>>> wind-upms-rpc-service 启动完成 <<<<<");
	}
}
