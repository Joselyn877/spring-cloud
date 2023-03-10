package com.jojo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

/**
 * @auther Easy
 * @date 2023/3/1 23:13
 * @revision 0.1 version
 */
@EnableDiscoveryClient
@SpringBootApplication
@Slf4j
@EnableFeignClients("com.jojo.**")
public class OrderServerApplication {

  private static ApplicationContext applicationContext;

  public static void main(String[] args){

    applicationContext = new SpringApplicationBuilder(OrderServerApplication.class).run(args);
  }
}
