package com.lisz.controller;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class HystrixTest extends HystrixCommand {
	private int count = 0;

	protected HystrixTest(HystrixCommandGroupKey group) {
		super(group);
	}

	public static void main(String[] args) throws Exception{
		// key是分组，不同的线程池，隔离。key是业务组的名称，按照他取出线程池
		HystrixTest hystrixTest = new HystrixTest(HystrixCommandGroupKey.Factory.asKey("k1"));
		System.out.println(hystrixTest.execute());
	}

	// try, 正常调用
	@Override
	protected Object run() throws Exception {
		System.out.println("正常处理中，但是可能会报异常...");
//		if (count++ % 3 == 0) {int i = 10 / 0;}
		return "ok";
	}

	// catch，备用逻辑，降级处理
	@Override
	protected Object getFallback() {
		return "调用发生错误，返回降级结果";
	}
}
