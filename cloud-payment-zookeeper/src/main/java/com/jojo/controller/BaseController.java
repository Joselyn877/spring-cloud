package com.jojo.controller;

/**
 * @auther Easy
 * @date 2023/3/9 16:03
 * @revision 0.1 version
 */

import com.jojo.entry.CommonResult;
import com.jojo.service.PaymentService;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
  public CommonResult get(@RequestParam("id")Long id){
    log.info("BaseController get() >>>>>>");
    log.info("id:"+id);
    CommonResult result = service.getPaymentById(id);
    return result;
  }
}
