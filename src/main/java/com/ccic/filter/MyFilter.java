package com.ccic.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author :hzs
 * @Date :Created in 15:55 2019/12/2
 * @Description :
 * Modified By   :
 * @Version ：
 **/
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("my filter process...");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
