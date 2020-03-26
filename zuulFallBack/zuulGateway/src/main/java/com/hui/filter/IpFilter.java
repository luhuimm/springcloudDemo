package com.hui.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.bouncycastle.asn1.ocsp.ResponseData;


import java.util.Arrays;
import java.util.List;

public class IpFilter  extends ZuulFilter {

    //Ip 黑名单
    private List<String> blackIpList = Arrays.asList("127.0.0.1");

    @Override
    public String filterType() {
        return "pre";
    }
    @Override
    public int filterOrder() {
        return 1;
    }
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext ctx = RequestContext.getCurrentContext();

        System.out.println(1/0);
//        String ip = ctx.getRequest();
        String ip = "127.0.0.1";
        if(StringUtils.isNotBlank(ip) &&
         blackIpList.contains(ip)) {
            ctx.setSendZuulResponse(false);
//            ctx.getResponse().setStatus(401);
            ctx.set("sendForwardFilter.ran",true);
            ctx.setResponseBody("error");
            ctx.getResponse().setContentType("application/json;charset=utf8");
            return null;
        }

        return null;
    }
}
