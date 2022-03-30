package com.lisz.controller;

import com.lisz.api.ConsumerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MainController {
	@Autowired
	private ConsumerApi consumerApi; // 写 UserApi 也行

	@GetMapping("/alive")
	public String alive(){
		return consumerApi.alive();
	}

	@GetMapping("/user/{id}")
	public String getById(@PathVariable int id){
		return consumerApi.getById(id);
	}

	@GetMapping("/map")
	public Map<Integer, String> map(int id){ // 参数名如果是?id=xxx,则可以省略@RequestParam,@RequestParam不允许空值，相当于包含了@NonNull
		System.out.println(id);
		return consumerApi.map(id);
	}

	@GetMapping("/map2")
	public Map<Integer, String> map2(Integer id, String name){
		System.out.println("id = " + id + " name = " + name);
		return consumerApi.map2(id, name);
	}

	@GetMapping("/map3")
	public Map<Integer, String> map3(@RequestParam Map<String, Object> map){
		System.out.println(map);
		return consumerApi.map3(map);
	}

	@GetMapping("/map4")
	public Map<Integer, String> map4(@RequestParam Map<String, Object> map){
		System.out.println(map);
		return consumerApi.map4(map);
	}
}
