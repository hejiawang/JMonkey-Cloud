package com.wang.jmonkey.cloud.modules.upms.controller;

import com.google.code.kaptcha.Producer;
import com.wang.jmonkey.cloud.common.constant.SecurityConstants;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 验证码controller
 * @Auther: HeJiawang
 * @Date: 2018/6/26
 */
@Controller
public class ValidateCodeController {

    @Autowired
    private Producer producer;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 创建验证码
     * @param randomStr
     * @param response
     */
    @GetMapping("/code/{randomStr}")
    public void createCode(@PathVariable String randomStr, HttpServletResponse response) throws Exception {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);

        //保存用户验证码，和randomStr绑定
        redisTemplate.opsForValue().set(SecurityConstants.DEFAULT_CODE_KEY + randomStr, text, SecurityConstants.DEFAULT_IMAGE_EXPIRE, TimeUnit.SECONDS);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "JPEG", out);
        IOUtils.closeQuietly(out);
    }
}
