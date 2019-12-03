package com.ccic.controller;

import com.ccic.exception.UserNotExistException;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Map;

/**
 * @Author :hzs
 * @Date :Created in 11:17 2019/11/25
 * @Description :
 * Modified By   :
 * @Version ：
 **/
@Controller
public class Helloworld {

    @ResponseBody
    @RequestMapping("hello")
    public String hello(@RequestParam("user")String user) {
        if (user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "hello world";
    }

    @RequestMapping("success")
    public String success(Map<String,Object> maps) {
        maps.put("hello" ,"你好");

        return "success";
    }


}
