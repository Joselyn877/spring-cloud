package com.jojo.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther Easy
 * @date 2023/3/22 11:04
 * @revision 0.1 version
 * sentinel是懒加载方式对服务进行监控，所以注册nacos与sentinel服务器之后需要访问一次该服务才可以看到dashboard信息
 */
@RestController
public class FlowLimitController {

  @GetMapping("/testA")
  public String testA(){
    return "testA";
  }

  @GetMapping("/testB")
  public String testB(){
    return "testB";
  }
}
