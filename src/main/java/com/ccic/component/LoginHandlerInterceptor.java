package com.ccic.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author :hzs
 * @Date :Created in 17:13 2019/11/26
 * @Description : 拦截器拦截未登陆请求 检查登录
 * Modified By   :
 * @Version ：
 **/
public class LoginHandlerInterceptor implements HandlerInterceptor {

    // 目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser == null) {
            // 未登录，返回登录页面
            request.setAttribute("msg", "没有权限，请先登录！");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        } else {
            // 已登录，放行请求
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
