package com.jojo.controller;

import com.jojo.entry.CommonResult;
import com.jojo.entry.Payment;
import com.jojo.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther Easy
 * @date 2023/2/21 22:31
 * @revision 0.1 version
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

  @Autowired
  public PaymentService paymentService;


  @GetMapping("/get")
  public CommonResult<Payment> payment(@RequestParam("id")Long id){
    log.debug("PaymentController begin>>>>>>>");
    Payment payment = paymentService.getPaymentById(id);
    log.info("payment",payment);
    if (payment == null){
      return new CommonResult<>(500,null);
    }
    return new CommonResult<Payment>(500,"success",payment);
  }
  @PostMapping("/create")
  public CommonResult count(Payment payment){
    int count = paymentService.create(payment);
    log.info("总条数:{}",count);
    if (count>0){
      return new CommonResult<>(200,"插入成功",count);
    }
    return new CommonResult<>(444,"插入失败");
  }


}
