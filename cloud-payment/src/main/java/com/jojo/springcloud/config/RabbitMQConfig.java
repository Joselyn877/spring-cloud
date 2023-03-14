package com.jojo.springcloud.config;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther Easy
 * @date 2023/2/28 22:56
 * @revision 0.1 version
 */
@Configuration
public class RabbitMQConfig {

  @Bean
  public Queue queue(){
    return new Queue("hello");
  }
}
