package cn.wolfcode.controller;

import cn.wolfcode.domain.Product;
import cn.wolfcode.service.IProductService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuxinyu
 * @date 2023/2/5
 * @apiNote
 */
@RestController
@Slf4j
public class ProductController {
    @Autowired
    private IProductService productService;

    @Value("${server.port}")
    private String port;
    //商品信息查询
    @RequestMapping("/products/{pid}")
    public Product findByPid(@PathVariable("pid") Long pid) {
        log.info("接下来要进行{}号商品信息的查询", pid);
        Product product = productService.findByPid(pid);
        log.info("商品信息查询成功,内容为{}", JSON.toJSONString(product));
        return product;
    }
}
