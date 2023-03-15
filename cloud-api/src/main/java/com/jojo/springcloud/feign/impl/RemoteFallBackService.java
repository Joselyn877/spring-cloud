package com.jojo.springcloud.feign.impl;

import com.jojo.springcloud.feign.RemoteService;
import com.jojo.springcloud.response.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @auther Easy
 * @date 2023/3/15 16:31
 * @revision 0.1 version
 * Feign全局降级
 *
 */
@Component
public class RemoteFallBackService implements RemoteService {

  @Override
  public CommonResult orderPayment(Long id) {
    return null;
  }

  @Override
  public String test() {
    return "RemoteFallBackService global fallback";
  }

  @Override
  public String timeOut() {
    return "RemoteFallBackService global fallback";
  }

  @Override
  public String callback() {
    return "RemoteFallBackService global fallback";
  }
}
