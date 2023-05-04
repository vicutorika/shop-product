package cn.wolfcode.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author xuxinyu
 * @date 2023/2/6
 * @apiNote
 */
@Service
@Slf4j
public class TraceServiceImpl {
    //将当前方法设置为一个可以进行流控配置的资源
    @SentinelResource(value = "traceService")
    public void tranceService(){
        log.info("调用traceService方法");
    }
}
