package com.jojo.springcloud.config;

import feign.Logger;
import feign.Logger.Level;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther Easy
 * @date 2023/3/14 20:09
 * @revision 0.1 version
 * feign日志增强
 */
@Configuration
public class FeignConfig {

  @Bean
  Logger.Level feignLoggerLevel(){
    return Level.FULL;
  }
}
