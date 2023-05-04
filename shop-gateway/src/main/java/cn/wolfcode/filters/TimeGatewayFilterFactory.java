package cn.wolfcode.filters;

import cn.wolfcode.filters.TimeGatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 *  自定义网关局部过滤器工厂类
 *  工厂名字定义限制
 *  1> 工厂名字必须按规则来
 *      格式: XxxGatewayFilterFactory,其中Xxx就是yml中filter配置过滤器
 *  2> 继承AbstractGatewayFilterFactory父类,明确指定一个泛型
 *      默认object,后续可以根据filters接收参数进行明确指定
 */
@Component
public class TimeGatewayFilterFactory extends AbstractGatewayFilterFactory<TimeGatewayFilterParam> {
    //指定获取配置参数之后封装成啥对象
    public TimeGatewayFilterFactory() {
        super(TimeGatewayFilterParam.class);
    }
    //将数据添加到哪个属性上
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("value1","value2");
    }
    //将自定义局部filter注册到网关
    @Override
    public GatewayFilter apply(TimeGatewayFilterParam config) {
        return new TimeGatewayFilter();
    }
}