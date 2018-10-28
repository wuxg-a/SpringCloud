package com.glodon.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String forTest(){

        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        System.out.println("/hello, host:" + instance.getHost() + ",service_id: " + instance.getServiceId());
        return "HelloWorld!";
    }

}
