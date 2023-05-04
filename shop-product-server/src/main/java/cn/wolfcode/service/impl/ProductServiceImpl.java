package cn.wolfcode.service.impl;


import cn.wolfcode.domain.Product;
import cn.wolfcode.mapper.ProductMapper;
import cn.wolfcode.service.IProductService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xuxinyu
 * @date 2023/2/5
 * @apiNote
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {
    @Autowired
    private  ProductMapper productMapper;
    @Override
    public Product findByPid(Long pid) {
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.eq("id",pid);
        Product product = productMapper.selectOne(wrapper);
        return product;
    }
}
