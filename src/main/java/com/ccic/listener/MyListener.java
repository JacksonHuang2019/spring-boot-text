package com.ccic.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Author :hzs
 * @Date :Created in 16:14 2019/12/2
 * @Description :
 * Modified By   :
 * @Version ：
 **/
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized  web应用启动了、、、");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println(" contextDestroyed  当前web项目销毁、、、");
    }
}
