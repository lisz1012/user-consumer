package com.lisz.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {
	@Autowired
	private RestTemplate restTemplate;

	// fallbackMethod 参数的值要跟下面的aliveFallback方法名一致
	@HystrixCommand(fallbackMethod = "aliveFallback",
					commandProperties = { // 如果想用SEMAPHORE信号量的方式隔离（而不是线程池隔离），则打开下面两行注释
//						@HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_STRATEGY, value = "SEMAPHORE"),
//						@HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_SEMAPHORE_MAX_CONCURRENT_REQUESTS, value = "1")
					})
	public String alive() {
		return restTemplate.getForEntity("http://user-provider/alive", String.class).getBody();
	}

	private String aliveFallback(){
		return "alive 降级处理了～～";
	}
}
