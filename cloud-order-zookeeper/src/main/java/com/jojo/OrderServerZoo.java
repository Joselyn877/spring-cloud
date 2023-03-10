package com.jojo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

/**
 * @auther Easy
 * @date 2023/3/9 16:28
 * @revision 0.1 version
 */
@SpringBootApplication
public class OrderServerZoo {

  private static ApplicationContext context;

  public static void main(String[] args) {
    context = new SpringApplicationBuilder(OrderServerZoo.class).run(args);
  }
}
