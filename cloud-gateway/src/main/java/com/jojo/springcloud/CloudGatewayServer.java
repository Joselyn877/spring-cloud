package com.jojo.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;

/**
 * @auther Easy
 * @date 2023/3/16 16:54
 * @revision 0.1 version
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudGatewayServer {

  private static ApplicationContext applicationContext ;

  public static void main(String[] args) {

    applicationContext = new SpringApplicationBuilder(CloudGatewayServer.class).run(args);
  }
}
