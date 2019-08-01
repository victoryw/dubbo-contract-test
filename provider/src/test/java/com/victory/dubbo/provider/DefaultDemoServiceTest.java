package com.victory.dubbo.provider;

import com.alibaba.dubbo.config.annotation.Reference;
import com.victory.dubbo.contract.DemoService;
import org.junit.Test;
import org.junit.jupiter.api.Tag;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles(profiles = "test")
public class DefaultDemoServiceTest {
    @Reference(version = "${demo.service.version}", url = "${demo.service.url}")
    private DemoService demoService;

    @Test
    public void sayHello() {
        final String givenVisitorName = "123";
        final String result = demoService.sayHello(givenVisitorName);
        assertEquals("Hello, 123 (from Spring Boot)", result);
    }
}