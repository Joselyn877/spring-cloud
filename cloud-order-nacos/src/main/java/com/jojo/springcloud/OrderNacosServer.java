package com.jojo.springcloud;

import com.jojo.springcloud.config.LoadBalanceConfig;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClientConfiguration;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

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
        @LoadBalancerClient(value = "cloud-nacos-payment-server", configuration = LoadBalanceConfig.class)
    }, defaultConfiguration = LoadBalancerClientConfiguration.class
)
//LoadBalancerClient单应用，LoadBalancerClients多应用，只需要在消费者方指明生产者以及负载均衡策略
//List<ServiceInstance> instances = discoverClient.getInstances("服务名")
//轮询算法（求余）：请求次数 % 服务器总数 = 实际调用服务器下标
public class OrderNacosServer {

  private static ApplicationContext applicationContext;

  public static void main(String[] args){

    applicationContext = new SpringApplicationBuilder(OrderNacosServer.class).run(args);
  }

  /**
   * 此配置为了服务监控而配置，与服务容错无关，springcloud升级之后流下的坑
   * ServletRegistrationBean因为springboot默认路径不是 "/hystrix.stream"
   * 只要在需要hystrixdashboard监控的项目里面加入以下配置即可
   * @return
   */
  @Bean
  public ServletRegistrationBean getServlet(){
    HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
    ServletRegistrationBean registrationBean = new ServletRegistrationBean<>(streamServlet);
    registrationBean.setLoadOnStartup(1);
    registrationBean.addUrlMappings("/hystrix.stream");
    registrationBean.setName("HystrixMetricsStreamServlet");
    return registrationBean;
  }
}
