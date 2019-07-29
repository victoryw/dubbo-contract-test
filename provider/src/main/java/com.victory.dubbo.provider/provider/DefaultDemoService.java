package com.victory.dubbo.provider.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.victory.dubbo.contract.DemoService;

@Service
public class DefaultDemoService implements DemoService {
    public String sayHello(String name) {
        return "Hello, " + name + " (from Spring Boot)";
    }
}
