package com.jojo.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther Easy
 * @date 2023/3/20 20:01
 * @revision 0.1 version
 */
@RestController
@RefreshScope     //支持nacos动态刷新功能,通过bootstrap.yml+application.yml组合切换获取nacos配置信息
public class NacosConfigController {

  @Value("${config.info}")
  private String configInfo;


  @GetMapping("/config/info")
  public String getConfigInfo(){
    return configInfo;
  }
}
