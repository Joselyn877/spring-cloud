package com.jojo.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther Easy
 * @date 2023/3/16 17:38
 * @revision 0.1 version
 * 1.yml配置方式写路由与断言，2.编码方式写路由与断言
 */
@Configuration
public class GatewayConfig {

  @Bean
  public RouteLocator router(RouteLocatorBuilder routeLocatorBuilder){

    RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

    routes.route("payment_routh3",
        r-> r.path("/payment/test")
            .uri("http://localhost:8001/payment/test")).build();

    return routes.build();
  }
}