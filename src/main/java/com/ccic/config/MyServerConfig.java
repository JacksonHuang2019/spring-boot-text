package com.ccic.config;

import com.ccic.filter.MyFilter;
import com.ccic.listener.MyListener;
import com.ccic.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.Arrays;


/**
 * @Author :hzs
 * @Date :Created in 15:41 2019/12/2
 * @Description :
 * Modified By   :
 * @Version ：
 **/
@Configuration
public class MyServerConfig {

    // 注册三大组件 servlet filter
    @Bean
    public ServletRegistrationBean myServletRegistrationBean() {

        ServletRegistrationBean servlet = new ServletRegistrationBean<>(new MyServlet(),"/myservlet");
        return servlet;
    }
    @Bean
    public ServletListenerRegistrationBean myListener() {
          return   new ServletListenerRegistrationBean<MyListener>(new MyListener());

    }
    @Bean
    public FilterRegistrationBean myFilterRegistrationBean() {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello","/myservlet"));
        return registrationBean;
    }
}
