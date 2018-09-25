package com.czp.servicefeign.controller;

import com.czp.servicefeign.service.HelloService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HiController {

    @Autowired
    private HelloService helloService;

    @ApiOperation(value="心跳检测服务", notes="打个招呼")
    @ApiImplicitParam
    @RequestMapping("/hello")
    public String sayHi(@RequestParam(value="name") String name) {
        return helloService.sayHiFromClientOne(name);
    }


    @ApiOperation(value="根据名称获取商户", notes="商户名称为字符串")
    @ApiImplicitParam(name="name", value = "商户名称", required = true, dataType = "String")
    @RequestMapping("/users/{name}")
    public Map<String, Object> getUser(@PathVariable String name) {
        return new HashMap<String, Object>() {{
            put("name", name);
        }};
    }

}
