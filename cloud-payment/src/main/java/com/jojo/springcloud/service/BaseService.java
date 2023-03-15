package com.jojo.springcloud.service;

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

  public String readTimeOut(){
    try{
      TimeUnit.SECONDS.sleep(3);
    }catch (Exception e){
      e.printStackTrace();
    }
    return  "time out";
  }
}
