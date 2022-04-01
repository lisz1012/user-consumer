package com.lisz.api;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="user-provider", fallbackFactory = UserProviderFallBackFactory.class/*url="http://localhost:8080"*/) // url直接调用，无LB
public interface ConsumerApi extends UserApi {
}
