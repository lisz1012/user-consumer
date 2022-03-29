package com.lisz.controller;

import com.lisz.api.ConsumerApi;
import com.lisz.api.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@Autowired
	private UserApi userApi;

	@GetMapping("/alive")
	public String alive(){
		return userApi.alive();
	}
}
