package com.jojo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @auther Easy
 * @date 2023/2/20 23:11
 * @revision 0.1 version
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(PaymentServerApplication.class,args);
  }
}
