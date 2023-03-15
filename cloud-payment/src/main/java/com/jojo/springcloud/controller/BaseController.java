package com.jojo.springcloud.controller;

import com.jojo.springcloud.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class BaseController {

  @Autowired
  private BaseService baseService;

  @GetMapping("/test")
  public String test(){
    return  baseService.test();
  }

  @GetMapping("/timeOut")
  public String timeOut(){
    return baseService.readTimeOut();
  }
}
