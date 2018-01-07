package com.changzhen.security.browser;

import com.changzhen.security.browser.support.SimpleResponse;
import com.changzhen.security.core.properties.SecurityProperties;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: changzhen
 * @Date: 2017/12/25
 * @Time: 下午3:49
 */
@Log4j
@RestController
public class BrowserSecurityController {

    @Autowired
    private SecurityProperties securityProperties;
    /**
     * 获取请求缓存
     */
    private RequestCache requestCache = new HttpSessionRequestCache();
    /**
     * 转发跳转地址
     */
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @RequestMapping("/authantication/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {

        SavedRequest savedRequest = requestCache.getRequest(request,response);

        if (savedRequest != null){
            String targetUrl = savedRequest.getRedirectUrl();
            log.info("引发跳转的地址是： " + targetUrl);
            if (StringUtils.endsWithIgnoreCase(targetUrl,"html")){
                log.info("登录页为： "+securityProperties.getBrowser().getLoginPage());
                redirectStrategy.sendRedirect(request,response,securityProperties.getBrowser().getLoginPage());
            }
        }


        return new SimpleResponse("访问的服务需要身份认证，请引导用户到登录页");
    }
}
