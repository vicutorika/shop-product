package cn.wolfcode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author xuxinyu
 * @date 2023/2/5
 * @apiNote
 */
@SpringBootApplication
@MapperScan("cn.wolfcode.mapper")
@EnableDiscoveryClient
@EnableFeignClients
public class OrderServer {
    //实例方法:构建实例对象交给容器管理
    @Bean
    @LoadBalanced //给restTemplate 赋予负载均衡调用功能
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderServer.class,args);
    }
}
