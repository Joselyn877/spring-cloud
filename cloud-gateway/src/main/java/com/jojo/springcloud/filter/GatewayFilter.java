package com.jojo.springcloud.filter;

import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @auther Easy
 * @date 2023/3/17 10:51
 * @revision 0.1 version
 * 自定义全局过滤器
 */

@Component
@Slf4j
public class GatewayFilter implements GlobalFilter, Ordered {

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    log.info("********GatewayFilter filter begin>>>>>>>>>"+new Date());
    String uname = exchange.getRequest().getQueryParams().getFirst("uname");  // 请求参数需要有uname
    if (uname == null){
      log.info("**********用户名不能为空，请检查！！");
      exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
      return exchange.getResponse().setComplete();
    }
    return chain.filter(exchange);
  }

  @Override
  public int getOrder() {
    return 0;
  }
}