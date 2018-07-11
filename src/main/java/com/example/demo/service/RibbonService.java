package com.example.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Service实现负载均衡和熔断
 */
@Service
public class RibbonService {
    @Autowired
    RestTemplate restTemplate;

    /**
     * HystrixCommand用来实现Hystrix熔断功能，restTemplate在RibbonConfig中实现了负载均衡
     * @return
     */
    @HystrixCommand(fallbackMethod = "hiError", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")})
    public String hi() {
        return restTemplate.getForObject("http://custom-service/hi", String.class);
    }

    public String hiError() {
        return "hi, sorry, error";
    }
}
