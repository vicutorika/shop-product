package cn.wolfcode.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class NacosConfigController {
    @Value("${appConfig.name}")
    private String appConfigName;
    @RequestMapping("/nacosConfig")
    public String nacosConfig(){
        return "远程信息:"+appConfigName;
    }
}