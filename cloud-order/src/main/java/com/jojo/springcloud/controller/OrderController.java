package com.jojo.springcloud.controller;

import com.jojo.springcloud.feign.RemoteService;
import com.jojo.springcloud.response.CommonResult;
import com.jojo.springcloud.entry.Payment;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  @Resource
  private DiscoveryClient discoveryClient;

  @GetMapping("/payment")
  @ResponseBody
  public CommonResult orderPayment(@RequestParam("id")Long id){
    log.debug("OrderController begin>>>>>>>");
    CommonResult comResult = remoteService.orderPayment(id);    // 走openfeign

    log.info("result:{}",comResult);
    return comResult;
  }

  @GetMapping("/payment/create")
  public CommonResult create(@RequestBody Payment payment){
    CommonResult result = restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);    //走RestTemplate

    return result;
  }

  @GetMapping("/payment-ribbon")
  public CommonResult payment(@RequestParam("id")Long id){
    log.info("payment method begin>>>>[{}]",id);
    //请求头
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    Map<String,Long> map = new HashMap<>();
    map.put("id",id);

    HttpEntity<HashMap<String,Long>> request = new HttpEntity(map,headers);

    CommonResult result = restTemplate.getForObject(
        PAYMENT_URL + "/payment/test", CommonResult.class,request);
    return result;
  }

  @GetMapping("/discover")
  public Object discoverd(){
    //获取eureka服务名称
    List<String> services = discoveryClient.getServices();
    for (String service : services) {
      log.info("服务名:"+service);
      //获取eureka实例
      List<ServiceInstance> instances = discoveryClient.getInstances(service);
      for (ServiceInstance instance : instances) {
        log.info("服务名:"+service+",请求地址:"+instance.getUri()+",端口:"+instance.getPort());
      }
    }
    return this.discoveryClient;
  }

}
