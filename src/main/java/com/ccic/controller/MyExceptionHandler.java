package com.ccic.controller;

import com.ccic.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author :hzs
 * @Date :Created in 10:03 2019/12/2
 * @Description :
 * Modified By   :
 * @Version ：
 **/
@ControllerAdvice
public class MyExceptionHandler {
    @ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public  Map<String, Object> handleException(Exception e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", "user.not.exist");
        map.put("message", e.getMessage());
        map.put("message", e.getMessage());
        return map;
    }
}
