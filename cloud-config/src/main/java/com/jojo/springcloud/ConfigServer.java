package com.jojo.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ApplicationContext;

/**
 * @auther Easy
 * @date 2023/3/20 10:41
 * @revision 0.1 version
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServer {

  private static ApplicationContext context;

  public static void main(String[] args) {
    context = new SpringApplicationBuilder(ConfigServer.class).run(args);
  }
}
