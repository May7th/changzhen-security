package com.changzhen.security.core.properties;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: changzhen
 * @Date: 2017/12/30
 * @Time: 下午10:38
 */

public class SmsCodeProperties {

    private int length = 4;
    private int expireIn = 60;
    private String url = "";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }
}
