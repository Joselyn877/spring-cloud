package com.jojo.springcloud.controller;

import com.jojo.springcloud.feign.NacosRemoteService;
import com.jojo.springcloud.feign.RemoteService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
  private NacosRemoteService remoteService;


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

  public String globalFallBack(@RequestParam("id")Long id){
    return "全局fallback";
  }

  /**
   * 熔断
   * @return
   */
  @HystrixCommand(fallbackMethod = "globalFallBack",commandProperties = {
      @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启熔断
      @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
      @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口区
      @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "6")//失败次数到达多少次后跳闸
  })      // 服务降级->进而熔断->恢复调用链路
  @GetMapping("/test")
  public String test(@RequestParam("id")Long id){
    log.info("test()>>>>>>> id:"+id);
    if (id<0){
      throw  new RuntimeException("****id不能小于0");
    }
    String uuid = UUID.randomUUID().toString();
    log.info("uuid:"+uuid);
    return Thread.currentThread().getName()+" "+remoteService.test()+" "+id;
  }
}
