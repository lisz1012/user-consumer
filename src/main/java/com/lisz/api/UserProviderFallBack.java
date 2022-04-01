package com.lisz.api;

import com.lisz.entity.User;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

/**
 * Hystrix降级的时候使用的类，必须实现fallback所在的@FeignClient所注解的那个接口
 */
public class UserProviderFallBack implements ConsumerApi{
	private String downGradeStr = "降级了";
	private Map<Integer, String> downGradeMap = Collections.singletonMap(0, "默认名字");
	private User downGradeUser = new User(0, "默认User");

	@Override
	public String alive() {
		return downGradeStr;
	}

	@Override
	public String getById(int id) {
		return downGradeStr;
	}

	@Override
	public Map<Integer, String> getMap(int id) {
		return downGradeMap;
	}

	@Override
	public Map<Integer, String> getMap2(int id, String name) {
		return downGradeMap;
	}

	@Override
	public Map<Integer, String> getMap3(Map<String, Object> map) {
		return null;
	}

	@Override
	public Map<Integer, String> postMap(Map<String, Object> map) {
		return downGradeMap;
	}

	@Override
	public User postMap2(User user) {
		return downGradeUser;
	}
}
