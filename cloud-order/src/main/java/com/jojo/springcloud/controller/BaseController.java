package com.jojo.springcloud.controller;

import com.jojo.springcloud.feign.RemoteService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther Easy
 * @date 2023/3/15 10:45
 * @revision 0.1 version
 */
@Slf4j
@RestController
@RequestMapping("/order")
@DefaultProperties(defaultFallback = "globalFallBack")
public class BaseController {

  @Autowired
  private RemoteService remoteService;

  @GetMapping("/test")
  public String test(){
    return remoteService.test();
  }

  @HystrixCommand(fallbackMethod = "fallBack",commandProperties = {
      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")
  })
  @GetMapping("/callback")
  public String callback(){
    log.info("callback>>>>>>>>>>>>>>>");
    int num = 10/0;
    return remoteService.callback();
  }

  public String fallBack(){
    return "订单系统异常";
  }


  @HystrixCommand(fallbackMethod = "timeOutBack",commandProperties = {
      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
  })
  @GetMapping("/timeOut")
  public String timeOut(){
    return remoteService.timeOut();
  }

  public String timeOutBack(){
    return "连接超时";
  }

  @HystrixCommand
  @GetMapping("/globalFallBack")
  public String fallback(){
    return remoteService.timeOut();
  }

  public String globalFallBack(){
    return "全局fallback";
  }
}
