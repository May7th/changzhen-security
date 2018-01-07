package com.changzhen.security.core.validate.code.image;

import com.changzhen.security.core.validate.code.Impl.AbstractValidateCodeProcessor;
import com.changzhen.security.core.validate.code.ValidateCode;
import com.changzhen.security.core.validate.code.ValidateCodeProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: changzhen
 * @Date: 2018/1/5
 * @Time: 上午11:03
 */
@Component("imageCodeProcessor")
public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {

    @Override
    protected void send(ServletWebRequest request, ImageCode imageCode) throws Exception {
        ImageIO.write(imageCode.getImage(), "JPEG", request.getResponse().getOutputStream());
    }
}
