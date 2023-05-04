package cn.wolfcode.controller;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xuxinyu
 * @date 2023/2/6
 * @apiNote
 */
public class RequestOriginParserDefinition implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest request){
        /**
         * 定义请求的什么地方获取来源信息
         * 比如我们可以要求所有的客户端需要在请求头中袖带来源信息
         *
         */
        String serviceName = request.getParameter("serviceName");;

        //String header = request.getHeader("serviceName");
        return serviceName;
    }


}
