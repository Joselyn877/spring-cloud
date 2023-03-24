package com.jojo.springcloud;

import io.seata.spring.boot.autoconfigure.SeataTCCFenceAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @auther Easy
 * @date 2023/3/22 17:24
 * @revision 0.1 version
 */
@SpringBootApplication(exclude = {SeataTCCFenceAutoConfiguration.class})
@EnableDiscoveryClient
@ComponentScan("io.seata.**")
public class OrderServiceApplication {

  private static ApplicationContext context;

  public static void main(String[] args) {

    context = new SpringApplicationBuilder(OrderServiceApplication.class).run(args);
  }
}
