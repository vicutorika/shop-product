package cn.wolfcode.controller;

import cn.wolfcode.domain.Order;
import cn.wolfcode.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuxinyu
 * @date 2023/2/5
 * @apiNote
 */
@RestController
@RequestMapping("orders")
public class OrderController {
    @Autowired
    private IOrderService orderService;
    @GetMapping("/save")  //测试方便使用Get方式
    public Order order(Long pid, Long uid){
        return orderService.createOrder(pid, uid);
    }
}
