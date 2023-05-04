package cn.wolfcode.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 检查所有请求是否带token参数,如果有放行,如果没有拒绝并提示
 */
@Component
public class AuthGlobalFilter  implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {


        String token = exchange.getRequest().getQueryParams().getFirst("token");
        ServerHttpResponse response = exchange.getResponse();
        if(!StringUtils.hasText(token)){
            //没登录
            System.out.println("没有登录");
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            //返回401状态
            //return response.setComplete();

            //但是一般访问接口应该返回json格式
            String ret = "{\"code\":401, \"msg\":\"没有登录\", \"data\":\"\"}";
            byte[] bits = ret.getBytes(StandardCharsets.UTF_8);
            //把字节数据转换成一个DataBuffer
            DataBuffer buffer = response.bufferFactory().wrap(bits);
            return response.writeWith(Mono.just(buffer));
        }

        return chain.filter(exchange);
    }
}