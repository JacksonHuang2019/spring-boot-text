package com.ccic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @Author :hzs
 * @Date :Created in 16:15 2019/11/26
 * @Description : 登录
 * Modified By   :
 * @Version ：
 **/
@Controller
public class LoginController {

//    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping("/user/login")
    public String  login(@RequestParam("username")String username,
                         @RequestParam("password")String password,
                         Map<String,Object> maps, HttpSession session) {

        if (!StringUtils.isEmpty(username) && "123123".equals(password)) {
            session.setAttribute("loginUser",username);
            // 登录成功！ // 防止表单重复提交 可以重定向
            return "redirect:/main.html";
        } else {
            maps.put("msg", "用户名密码错误");
            return "login";
        }
    }
}
