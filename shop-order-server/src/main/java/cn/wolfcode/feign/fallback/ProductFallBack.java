package cn.wolfcode.feign.fallback;

import cn.wolfcode.domain.Product;
import cn.wolfcode.feign.IProductFeginService;

/**
 * @author xuxinyu
 * @date 2023/2/6
 * @apiNote
 * Feign接口远程调用失败后(如:熔断,服务提供者异常)执行的降级处理
 */
public class ProductFallBack implements IProductFeginService {
    @Override
    public Product findByPid(Long pid) {
        Product product = new Product();
        product.setName("降级");
        return product;
    }
}
