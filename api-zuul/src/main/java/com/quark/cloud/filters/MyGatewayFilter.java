package com.quark.cloud.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/10/5/005.
 */
public class MyGatewayFilter extends ZuulFilter {

    private  static Logger logger = LoggerFactory.getLogger(MyGatewayFilter.class);

    /**
     * 过滤类型 pre、post、error、static。。
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤顺序 可以不连续
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否要调用run方法
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器核心方法
     * @return
     */
    @Override
    public Object run() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String accessToken = request.getParameter("accessToken");
        //简单token校验
        if(accessToken == null ||"".equals(accessToken)){
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
//            try {
//                currentContext.setResponseBody(new String("token校验失败".getBytes("iso-8859-1"),"utf-8"));
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
            currentContext.setResponseBody("token valid failed");
            return "catch exception in filter";
        }
        logger.info("token valid success");
        return "success";
    }
}
