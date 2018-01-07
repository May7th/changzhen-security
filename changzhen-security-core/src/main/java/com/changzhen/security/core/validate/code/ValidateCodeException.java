package com.changzhen.security.core.validate.code;


import org.springframework.security.core.AuthenticationException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: changzhen
 * @Date: 2017/12/26
 * @Time: 下午4:38
 */
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
