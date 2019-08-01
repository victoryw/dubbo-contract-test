package com.victory.dubbo.contract;

public class DemoServiceStub implements DemoService {

    private final DemoService remoteServiceProxy;

    public DemoServiceStub(DemoService remoteServiceProxy) {
        this.remoteServiceProxy = remoteServiceProxy;
    }

    public String sayHello(String name) {
        return name;
    }
}
