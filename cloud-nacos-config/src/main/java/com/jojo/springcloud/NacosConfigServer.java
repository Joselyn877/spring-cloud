package com.jojo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @auther Easy
 * @date 2023/3/20 19:59
 * @revision 0.1 version
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigServer {
  
  public static void main(String[] args) {

    new SpringApplication(NacosConfigServer.class).run(args);
  }
}
