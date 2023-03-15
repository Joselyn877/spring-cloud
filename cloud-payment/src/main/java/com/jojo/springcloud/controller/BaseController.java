package com.jojo.springcloud.controller;

import com.jojo.springcloud.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther Easy
 * @date 2023/3/14 20:54
 * @revision 0.1 version
 */
@RestController
@RequestMapping("/base")
@Slf4j
public class BaseController {

  @Value("${server.port}")
  private String port;
  @Autowired
  private BaseService baseService;

  @GetMapping("/test")
  public String test(){
    log.info("BaseController test>>>>>>>>>>>");
    return  baseService.test()+" "+port;
  }


  @GetMapping("/timeOut")
  public String timeOut(){
    log.info("BaseController timeOut>>>>>>>>>>>");
    return baseService.readTimeOut()+" "+port;
  }

  @GetMapping("/callback")
  public String callback(){
    log.info("BaseController timeOut>>>>>>>>>>>");
    return baseService.callback()+" "+port;
  }

}
