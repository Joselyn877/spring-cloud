package com.jojo.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Service;

/**
 * @auther Easy
 * @date 2023/3/14 20:55
 * @revision 0.1 version
 */
@Service
public class BaseService {

  public String test(){
    return "hello hystrix";
  }

  /**
   * 处理超时
   * @return
   */
  @HystrixCommand(fallbackMethod = "fallBackHandle",commandProperties = {
      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
  })
  public String readTimeOut(){
    //1.处理超时
    try{
      TimeUnit.SECONDS.sleep(5);
    }catch (Exception e){
      e.printStackTrace();
    }
    return  "time out";
  }

  /**
   * 执行报错
   * @return
   */
  @HystrixCommand(fallbackMethod = "backHandle",commandProperties = {
      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
  })
  public String callback(){
    //2.执行报错
    int age = 10/0;
    return  "time out";
  }
  public String fallBackHandle(){
    return "处理超时，该服务不可用";
  }

  public String backHandle(){
    return "执行错误，该服务不可用";
  }
}
