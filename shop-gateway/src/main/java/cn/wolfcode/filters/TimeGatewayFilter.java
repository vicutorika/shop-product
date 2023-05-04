package cn.wolfcode.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author xuxinyu
 * @date 2023/2/8
 * @apiNote
 * 计算时间过滤器
 */
public class TimeGatewayFilter implements GatewayFilter, Ordered {

    public TimeGatewayFilter() {
    }
    private TimeGatewayFilterParam config;
    private TimeGatewayFilter(TimeGatewayFilterParam config){
        this.config = config;
    }

    /**
     *过滤逻辑
     * @param exchange 转换器--封装了来自请求中所有信息,请求参数,请求路径,请求头,cookie等
     * @param chain 过滤器链 -- 使用责任链模式,决定当前过滤器是放行还是拒绝
     * @return Mono 响应式编程的返回值规范, 一般后置拦截才会用
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //前置拦截
        //统计时间：进来(pre前置)记当前时间， 出去(post后置)记当前时间，2者差值就是运行时间
        long begin = System.currentTimeMillis();
        System.out.println("前置当前时间：" + begin);
        //后置拦截
        //chain.filter(exchange) 过滤器放行
        return chain.filter(exchange).then(Mono.fromRunnable(()->{
            long end = System.currentTimeMillis();
            System.out.println("后置当前时间：" + end);
            System.out.println(config.getValue2()+ "两者时间差：" + (end-begin));
        }));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
