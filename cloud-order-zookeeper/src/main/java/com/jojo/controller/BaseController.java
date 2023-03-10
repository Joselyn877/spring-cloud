package com.jojo.controller;

import com.jojo.entry.CommonResult;
import java.util.HashMap;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @auther Easy
 * @date 2023/3/9 16:30
 * @revision 0.1 version
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class BaseController {
  public static final String PAYMENT_URL= "http://cloud-zookeeper-payment-server";
  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private DiscoveryClient discoveryClient;

  @GetMapping("/payment")
  @ResponseBody
  public CommonResult getPayment(@RequestParam("id")Long id){
    log.info("id:"+id);
    HashMap<Object, Object> map = new HashMap<>();
    map.put("id",id);
    CommonResult result = restTemplate.postForObject(PAYMENT_URL + "/payment/get",map,CommonResult.class);
    return result;
  }

  @GetMapping("/discover")
  public void discover(){
    List<String> services = discoveryClient.getServices();
    for (String service : services) {
      System.out.println(service);
    }
  }
}
