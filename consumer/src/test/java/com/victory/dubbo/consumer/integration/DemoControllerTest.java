package com.victory.dubbo.consumer.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(profiles = "test")
public class DemoControllerTest {

    @LocalServerPort
    private int port;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void should_return_remote_hello_world() {
        final String helloClient = "wy";
        final String url = String.format("http://localhost:%d/say-hello?name=%s", port, helloClient);
        final ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("wy", result.getBody());

    }
}
