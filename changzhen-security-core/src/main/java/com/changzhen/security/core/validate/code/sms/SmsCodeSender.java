package com.changzhen.security.core.validate.code.sms;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: changzhen
 * @Date: 2018/1/4
 * @Time: 下午10:29
 */
public interface SmsCodeSender {
    /**
     * 短信验证码接口
     * @param mobile
     * @param code
     */
    void send(String mobile, String code);
}
