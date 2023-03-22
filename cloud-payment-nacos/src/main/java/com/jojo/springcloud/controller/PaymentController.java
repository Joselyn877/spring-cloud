package com.jojo.springcloud.controller;

import com.jojo.springcloud.entry.Payment;
import com.jojo.springcloud.response.CommonResult;
import com.jojo.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
  @Value("${server.port}")
  private String port;

  @Autowired
  public PaymentService paymentService;


  @GetMapping("/get")
  public CommonResult<Payment> payment(@RequestParam("id")Long id){
    log.debug("PaymentController begin>>>>>>>");
    CommonResult<Payment> payment = paymentService.getPaymentById(id);
    log.info("payment",payment);
    if (payment == null){
      return new CommonResult<>(500,null);
    }
    return new CommonResult<Payment>(200,"success",payment.getData());
  }
  @PostMapping("/create")
  public CommonResult count(@RequestBody Payment payment){
    int count = paymentService.create(payment);
    log.info("总条数:{}",count);
    if (count>0){
      return new CommonResult<>(200,"插入成功",count);
    }
    return new CommonResult<>(444,"插入失败");
  }

  @GetMapping("/test")
  public CommonResult test(){
    log.info("test >>>>>");
    CommonResult result = new CommonResult(500,"port: "+port);
    return result;
  }

}
