package com.jojo.springcloud.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/**
 * @auther Easy
 * @date 2023/3/14 15:41
 * @revision 0.1 version
 */
// 定义使用的负载均衡器CustomAlgmLoadBalancer（3的倍数切换）
// 注意：不能使用 @Configuration 标注此类是配置类，否则会抛出异常
public class LoadBalanceConfig {
  @Bean
  ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(Environment environment,LoadBalancerClientFactory loadBalancerClientFactory) {
    //获取服务名srping.application.name
    String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
//    return new RandomLoadBalancer(loadBalancerClientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class),name);//随机
    return new CustomAlgmLoadBalancer(loadBalancerClientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class),name);//自定义策略
  }
}
