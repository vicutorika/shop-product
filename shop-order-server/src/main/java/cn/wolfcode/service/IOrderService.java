package cn.wolfcode.service;

import cn.wolfcode.domain.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author xuxinyu
 * @date 2023/2/5
 * @apiNote
 */
public interface IOrderService extends IService<Order> {
    Order createOrder(Long pid, Long uid);
}
