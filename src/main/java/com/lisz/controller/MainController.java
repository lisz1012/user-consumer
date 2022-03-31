package com.lisz.controller;

import com.lisz.api.ConsumerApi;
import com.lisz.entity.User;
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
		return consumerApi.getMap(id);
	}

	@GetMapping("/map2")
	public Map<Integer, String> map2(Integer id, String name){
		System.out.println("id = " + id + " name = " + name);
		return consumerApi.getMap2(id, name);
	}

	@GetMapping("/map3")
	public Map<Integer, String> map3(@RequestParam Map<String, Object> map){ // 拿Map接参数的时候，用着用不着的都可以接，但要写@RequestParam
		System.out.println(map);
		return consumerApi.getMap3(map);
	}

	@GetMapping("/map4")
	public Map<Integer, String> map4(@RequestParam Map<String, Object> map){
		System.out.println(map);
		return consumerApi.postMap(map);
	}

	@GetMapping("/map5")
	public User map5(@RequestParam Map<String, Object> map){
		System.out.println(map);
		return consumerApi.postMap2(new User( Integer.parseInt(map.get("id").toString()), map.get("name").toString()));
	}
}
