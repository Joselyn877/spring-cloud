package com.jojo.controller;

import com.jojo.RemoteService;
import com.jojo.entry.CommonResult;
import com.jojo.entry.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @auther Easy
 * @date 2023/3/2 20:02
 * @revision 0.1 version
 */
@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

  public static final String PAYMENT_URL= "http://cloud-payment-server";
  @Autowired
  private RemoteService remoteService;
  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/payment")
  @ResponseBody
  public CommonResult orderPayment(@RequestParam("id")Long id){
    log.debug("OrderController begin>>>>>>>");
    CommonResult comResult = remoteService.orderPayment(id);    // 走openfeign

    log.info("result:{}",comResult);
    return comResult;
  }

  @GetMapping("/payment/create")
  public CommonResult create(Payment payment){
    CommonResult result = restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);    //走RestTemplate

    return result;
  }

}
