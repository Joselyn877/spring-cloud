package com.jojo.springcloud;

import com.jojo.springcloud.config.LoadBalanceConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClientConfiguration;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

/**
 * @auther Easy
 * @date 2023/3/1 23:13
 * @revision 0.1 version
 */
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients("com.jojo.springcloud.feign")
@LoadBalancerClients(
    value = {
        @LoadBalancerClient(value = "cloud-payment-server", configuration = LoadBalanceConfig.class)
    }, defaultConfiguration = LoadBalancerClientConfiguration.class
)
//LoadBalancerClient单应用，LoadBalancerClients多应用，只需要在消费者方指明生产者以及负载均衡策略
//List<ServiceInstance> instances = discoverClient.getInstances("服务名")
//轮询算法（求余）：请求次数 % 服务器总数 = 实际调用服务器下标
public class OrderServerApplication {

  private static ApplicationContext applicationContext;

  public static void main(String[] args){

    applicationContext = new SpringApplicationBuilder(OrderServerApplication.class).run(args);
  }
}
