package com.czp.serviceribbon.controller;

import com.czp.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public String helloController(@RequestParam(name="name", defaultValue = "czp") String name) {
        String result = helloService.hiService(name);

        return "This is Ribbon's result: " + result;
    }

}
