package cn.wolfcode.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author xuxinyu
 * @date 2023/2/7
 * @apiNote
 */
@RestController
@Slf4j
public class FallBackController {
    @RequestMapping("/dallBack1")
    public String fallBack1() {
        try {
            log.info("fallBack1执行逻辑");
            //模拟业务耗时
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "fallBack1";
    }

    int i = 0;

    @RequestMapping("/fallBack2")
    public String fallBack2() {
        log.info("fallBack2执行逻辑");
        //模拟出现异常.异常比例为33%
        if (++i % 3 == 0) {
            throw new RuntimeException();
        }
        return "fallBack2";
    }
}
