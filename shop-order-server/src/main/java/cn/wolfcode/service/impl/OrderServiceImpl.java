package cn.wolfcode.service.impl;

import cn.wolfcode.domain.Order;
import cn.wolfcode.domain.Product;
import cn.wolfcode.feign.IProductFeginService;
import cn.wolfcode.mapper.OrderMapper;
import cn.wolfcode.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author xuxinyu
 * @date 2023/2/5
 * @apiNote
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
    @Autowired
    private RestTemplate restTemplate;
    //在java
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private IProductFeginService productFeginService;

    @Override
    public Order createOrder(Long pid, Long uid) {
        Order order = new Order();

        //用户信息--假装从member--server查询出用户信息
        order.setUid(1L);
        order.setUsername("dafei");

        //商品信息--需要远程地哦啊用商品服务/products/pid接口
        //java代码发起http请求即可

        //远程调用实现方案
        //1 使用RestTemplate方式
        //URL硬编码, 无法记性负载均衡(无法应对集群)
        //String url = "http://localhost:8081/products/1";
        //参数1:http请求URL地址, 参数2:响应返回值类型


        //方案2:使用Nacos-discoveryClient方式
        // 缺点:无法进行负载均衡(无法应对集群)
        /*List<ServiceInstance> instances = discoveryClient.getInstances("product-service");//获取实例对象--获取微服务--获取注册中心中的服务实例
        ServiceInstance instance = instances.get(0);
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/products/" + pid;
        Product p = restTemplate.getForObject(url, Product.class);*/

        //方案3 使用Nacos-discoveryClient方式--手动配置负载均衡
        /*List<ServiceInstance> instances = discoveryClient.getInstances("product-service");//获取实例对象--获取微服务--获取注册中心中的服务实例
        int index = new Random().nextInt(2);
        ServiceInstance instance = instances.get(0 / 1);
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/products/" + pid;
        Product p = restTemplate.getForObject(url, Product.class);*/
        
        //方案4 使用负载均衡组件Ribbon -- @LoadBalanced
        //String url = "http://product-service/products/"+pid;
        //Product p = restTemplate.getForObject(url, Product.class);

        //方案5:使用feign接口--带负载均衡

        Product p = productFeginService.findByPid(pid);
        order.setPid(pid);
        order.setProductName(p.getName());
        order.setProductPrice(p.getPrice());
        order.setNumber(1);

        super.save(order);
        return order;
    }

}
