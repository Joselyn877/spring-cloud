package com.jojo.springcloud.feign.impl;

import com.jojo.springcloud.feign.NacosRemoteService;
import com.jojo.springcloud.response.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @auther Easy
 * @date 2023/3/15 16:31
 * @revision 0.1 version
 * Feign全局降级，实现接口RemoteService，fallback = RemoteFallBackService.class
 *
 */
@Component
public class NacosRemoteFallBackService implements NacosRemoteService {

  @Override
  public CommonResult orderPayment(Long id) {
    return null;
  }

  @Override
  public String test() {
    return "NacosRemoteFallBackService global fallback";
  }

  @Override
  public String timeOut() {
    return "NacosRemoteFallBackService global fallback";
  }

  @Override
  public String callback() {
    return "NacosRemoteFallBackService global fallback";
  }
}
