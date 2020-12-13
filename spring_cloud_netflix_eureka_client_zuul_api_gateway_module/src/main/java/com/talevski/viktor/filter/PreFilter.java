package com.talevski.viktor.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;

public class PreFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();
        System.out.println("Request Method - '" + httpServletRequest.getMethod() + "'. Request URL - '" + httpServletRequest.getRequestURL().toString() + "'.");
        return null;
    }
}
