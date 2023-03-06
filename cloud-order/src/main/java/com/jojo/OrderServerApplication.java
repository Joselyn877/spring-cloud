package com.jojo;

import com.jojo.config.RestTemplateConfig;
import java.lang.reflect.Method;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
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

  public static void main(String[] args) throws NoSuchMethodException {

    applicationContext = new SpringApplicationBuilder(OrderServerApplication.class).run(args);
    Class aClass = applicationContext.getBean(RestTemplateConfig.class).getClass();
    Method method = aClass.getMethod("getRestTemplate");
    log.info(">>>>>>method:[{}]",method);
  }
}
