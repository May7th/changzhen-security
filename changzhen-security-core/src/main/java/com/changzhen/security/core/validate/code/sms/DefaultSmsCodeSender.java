package com.changzhen.security.core.validate.code.sms;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: changzhen
 * @Date: 2018/1/4
 * @Time: 下午10:31
 */
public class DefaultSmsCodeSender implements SmsCodeSender{

    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机 "+mobile+" 发送短信验证码："+code);
    }
}
