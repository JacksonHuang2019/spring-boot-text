package com.ccic.exception;

/**
 * @Author :hzs
 * @Date :Created in 9:38 2019/12/2
 * @Description :
 * Modified By   :
 * @Version ：
 **/
public class UserNotExistException extends RuntimeException {

    public UserNotExistException() {
        super("用户不存在");
    }

}
