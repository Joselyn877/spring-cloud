package com.jojo.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.ApplicationContext;

/**
 * @auther Easy
 * @date 2023/3/16 15:36
 * @revision 0.1 version
 */
@SpringBootApplication
@EnableHystrixDashboard
public class CloudHystrixDashBoardServer {

  private static ApplicationContext context;

  public static void main(String[] args) {

    context= new SpringApplicationBuilder(CloudHystrixDashBoardServer.class).run(args);
  }
}
