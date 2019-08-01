package com.victory.dubbo.provider;

import com.alibaba.dubbo.config.annotation.Reference;
import com.victory.dubbo.contract.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles(profiles = "test-rest")
public class DefaultDemoServiceRestTest {
    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Value("${dubbo.protocol.port}")
    private String port;

    @Test
    public void sayHello() {
        final String helloClient = "wy";
        final String url = String.format("http://localhost:%s/users/hello-world/%s", port, helloClient);
        final ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("Hello, wy (from Spring Boot)", result.getBody());
    }
}