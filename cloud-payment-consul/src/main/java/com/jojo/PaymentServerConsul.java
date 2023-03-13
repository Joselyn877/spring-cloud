package com.jojo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;

/**
 * @auther Easy
 * @date 2023/3/13 16:56
 * @revision 0.1 version
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentServerConsul {

  private static ApplicationContext context;

  public static void main(String[] args) {

    context = new SpringApplicationBuilder(PaymentServerConsul.class).run(args);
  }
}
