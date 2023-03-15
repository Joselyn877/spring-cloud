package com.jojo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @auther Easy
 * @date 2023/3/2 16:56
 * @revision 0.1 version
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(EurekaServerApplication.class,args);
  }
}
