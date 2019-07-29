package com.victory.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.victory.dubbo.contract.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Reference(version = "${demo.service.version}", url = "${demo.service.url}")
    private DemoService demoService;

    @RequestMapping("/say-hello")
    public String sayHello(@RequestParam String name) {
        return demoService.sayHello(name);
    }
}
