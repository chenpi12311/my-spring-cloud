package com.czp.servicefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="service-hi", fallback = HelloServiceHystrix.class)
public interface HelloService {

    @RequestMapping("/hi")
    public String sayHiFromClientOne(@RequestParam(value="name") String name);

}
