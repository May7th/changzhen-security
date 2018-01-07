package com.changzhen.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: changzhen
 * @Date: 2018/1/4
 * @Time: 下午2:33
 */
public interface ValidateCodeGenerator {

    /**
     * 创建验证码接口
     * @param request
     * @return
     */
    ValidateCode generate(ServletWebRequest request);
}
