package com.ccic.config;


import com.ccic.component.LoginHandlerInterceptor;
import com.ccic.component.MyLocaleResolver;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


// 使用WebMvcConfigurerAdapter 扩展springmvc的功能
/**
 * @Author :hzs
 * @Date :Created in 10:19 2019/11/26
 * @Description :
 * Modified By   :
 * @Version ：
 **/
@Configuration
public class MyConfig  implements WebMvcConfigurer{

    // 添加servlet


    public EmbeddedWebServerFactoryCustomizerAutoConfiguration myEmbeddedWebServerFactoryCustomizerAutoConfiguration() {

        return  new EmbeddedWebServerFactoryCustomizerAutoConfiguration();
    }

   // 添加视图映射

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("ccic").setViewName("success");
//        registry.addViewController("/").setViewName("login");
    }

    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 静态资源 springboot已经做好了静态资源映射了
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html","/user/login");
    }*/

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("main.html").setViewName("dashboard");
            }
            // 注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                // 静态资源 springboot已经做好了静态资源映射了
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns( "/", "/index.html","/user/login");
            }
        };
        return  webMvcConfigurer;
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
