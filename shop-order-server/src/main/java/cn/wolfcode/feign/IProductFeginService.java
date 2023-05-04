package cn.wolfcode.feign;

import cn.wolfcode.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
public interface IProductFeginService {
    @GetMapping("/products/{pid}")
    Product findByPid(@PathVariable("pid") Long pid);
}