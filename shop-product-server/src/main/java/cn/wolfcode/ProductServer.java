package cn.wolfcode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xuxinyu
 * @date 2023/2/5
 * @apiNote
 */
@SpringBootApplication
@MapperScan("cn.wolfcode.mapper")
@EnableDiscoveryClient
public class ProductServer {
    public static void main(String[] args) {
        SpringApplication.run(ProductServer.class,args);
    }
}
