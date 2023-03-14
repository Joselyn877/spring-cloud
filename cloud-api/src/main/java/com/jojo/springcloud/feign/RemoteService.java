package com.jojo.springcloud.feign;

import com.jojo.springcloud.response.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @auther Easy
 * @date 2023/3/2 19:52
 * @revision 0.1 version
 */
@FeignClient(name = "cloud-payment-server")
public interface RemoteService {

  @GetMapping("/payment/get")
  CommonResult orderPayment(@RequestParam("id")Long id);

}
