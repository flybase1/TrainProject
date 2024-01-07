package com.example.project08;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.captcha.ShearCaptcha;
import cn.hutool.captcha.generator.MathGenerator;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;


@RestController
@RequestMapping( "test" )
@Slf4j
public class QrCodeUtilTest {

    @Autowired
    HttpServletResponse response;
    @Autowired
    HttpSession session;

    @GetMapping( "code" )
    void getCode() throws IOException {
        // 利用 hutool 工具，生成验证码图片资源
        //CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(200, 100, 4, 5);

        // ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(200, 100, 4, 4);

        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(1200, 450, 4, 4);
        // 自定义验证码内容为四则运算方式
        captcha.setGenerator(new MathGenerator());

        // 获得生成的验证码字符
        String code = captcha.getCode();
        // 利用 session 来存储验证码
        session.setAttribute("code", code);
        log.info("code=>" + code);
        // 将验证码图片的二进制数据写入【响应体 response 】
        captcha.write(response.getOutputStream());
    }


    @GetMapping( "/qr" )
    void getQrCode() throws IOException {
        QrConfig config = new QrConfig(300, 300);
        // 设置边距，既二维码和背景之间的边距
        config.setMargin(3);
        // 设置前景色，既二维码颜色（青色）
        config.setForeColor(Color.CYAN.getRGB());
        // 设置背景色（灰色）
        config.setBackColor(Color.GRAY.getRGB());
        // 生成二维码到文件，也可以到流
        String tartgetType = "jpg";
        QrCodeUtil.generate("王政大帅逼", config, tartgetType, response.getOutputStream());
    }
}