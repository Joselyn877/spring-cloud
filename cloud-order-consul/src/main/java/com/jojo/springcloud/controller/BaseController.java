package com.jojo.springcloud.controller;

import com.jojo.springcloud.response.CommonResult;
import java.util.HashMap;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
  public static final String PAYMENT_URL= "http://cloud-consul-payment-server";
  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private DiscoveryClient discoveryClient;

  @GetMapping("/payment")
  @ResponseBody
  public CommonResult getPayment(@RequestParam("id")Long id){
    log.info("BaseController getPayment() >>>>");
    //请求头
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    //请求参数
    HashMap<String, Long> map = new HashMap<>();
    map.put("id",id);

    HttpEntity<HashMap<String,Long>> request = new HttpEntity<>(map,headers);

    // RestTemplate.postForEntity(),返回包含重要的信息，比如响应头、响应状态码、响应体等
    ResponseEntity response = restTemplate.postForEntity(PAYMENT_URL + "/payment/get",request,CommonResult.class);
    CommonResult<ResponseEntity> result = new CommonResult<>();
    result.setData(response);
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
