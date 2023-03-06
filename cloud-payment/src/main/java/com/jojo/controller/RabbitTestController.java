package com.jojo.controller;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther Easy
 * @date 2023/2/28 23:59
 * @revision 0.1 version
 */
@RestController
public class RabbitTestController {

  @Autowired
  private RabbitTemplate rabbitTemplate;


  @GetMapping("/message")
  @ResponseBody
  public String simpleTest(){
    rabbitTemplate.convertAndSend("simple","this is news");
    return "ok";
  }

  @RabbitListener(queuesToDeclare = @Queue("simple"))
  public void consume(String message){
    System.out.println(message);
  }
}
