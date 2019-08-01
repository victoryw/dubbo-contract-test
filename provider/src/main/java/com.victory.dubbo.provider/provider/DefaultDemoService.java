package com.victory.dubbo.provider.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.victory.dubbo.contract.DemoService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Service(version = "${demo.service.version}")
@Path("/users")
public class DefaultDemoService implements DemoService {

    @Path("hello-world/{name}")
    @GET
    public String sayHello(@PathParam("name") String name) {
        return "Hello, " + name + " (from Spring Boot)";
    }
}
