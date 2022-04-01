package com.lisz.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "aliveFallback") // 参数的值要跟下面的aliveFallback方法名一致
	public String alive() {
		return restTemplate.getForEntity("http://user-provider/alive", String.class).getBody();
	}

	private String aliveFallback(){
		return "alive 降级处理了～～";
	}
}
