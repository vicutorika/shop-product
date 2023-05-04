package cn.wolfcode.service;

import cn.wolfcode.domain.Product;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author xuxinyu
 * @date 2023/2/5
 * @apiNote
 */
public interface IProductService extends IService<Product> {
    Product findByPid(Long pid);
}
