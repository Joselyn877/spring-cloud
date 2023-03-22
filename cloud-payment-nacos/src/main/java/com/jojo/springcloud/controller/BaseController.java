package com.jojo.springcloud.controller;

/**
 * @auther Easy
 * @date 2023/3/9 16:03
 * @revision 0.1 version
 */

import com.jojo.springcloud.response.CommonResult;
import com.jojo.springcloud.service.PaymentService;
import java.util.Map;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@Slf4j
public class BaseController {

  @Value("${server.port}")
  private String serverPort;
  @Value("${spring.application.name}")
  private String serverName;
  @Autowired
  private PaymentService service;

  @GetMapping("/zk")
  public String paymentzk(){
    log.info("BaseController paymentzk() >>>>>>");
    return "server:"+serverName+"   port: "+serverPort+ UUID.randomUUID();
  }
  @PostMapping("/get")
  @ResponseBody
  public CommonResult get(@RequestBody Map<String,Long> map){
    log.info("BaseController get() request[{}]>>>>>>",map);

    CommonResult result = service.getPaymentById(map.get("id"));
    return result;
  }
}
