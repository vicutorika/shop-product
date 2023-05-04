package cn.wolfcode.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuxinyu
 * @date 2023/2/6
 * @apiNote
 */
@RestController
@Slf4j
public class AnnoController {
    //需求: 当触发流控规则之后, 默认情况往客户端抛异常
    //因为业务需要, 当抛出异常时, 需要进行额外业务
    @RequestMapping("/anno1")
    @SentinelResource(value = "anno1"
        ,blockHandler = "anno1BlockHandler"
        ,fallback = "anno1Fallback")
    public String anno1(String name){
        if ("wolfcode".equals(name)){
            throw new RuntimeException();
        }
        return "anno1";
    }

    //当anno1接口触发流程规则之后, 马上执行当前方法
    public String anno1BlockHandler(String name, BlockException ex){
        log.error("{}", ex);
        return "接口被限流或者降级了";
    }
    //Throwable时进入的方法
    //当anno1接口执行报错之后, 马上执行当前方法
    public String anno1Fallback(String name,Throwable throwable) {
        log.error("{}", throwable);
        return "接口发生异常了";
    }
}
