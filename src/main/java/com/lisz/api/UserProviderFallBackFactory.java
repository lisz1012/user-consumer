package com.lisz.api;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class UserProviderFallBackFactory implements FallbackFactory<ConsumerApi> {
	private static final UserProviderFallBack INSTANCE = new UserProviderFallBack();
	@Override
	public ConsumerApi create(Throwable cause) {
		System.out.println(cause);
		return INSTANCE;
	}
}
