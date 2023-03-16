package com.jojo.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * @auther Easy
 * @date 2023/2/20 23:11
 * @revision 0.1 version
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableCircuitBreaker
public class PaymentServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(PaymentServerApplication.class,args);
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
