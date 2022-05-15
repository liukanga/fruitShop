package com.zcy.fruitshop.controller;

import com.google.code.kaptcha.Producer;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    private Producer kaptchaProducer;

    @ApiOperation("游客访问")
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @ApiOperation("验证码生成")
    @RequestMapping( "kaptcha.png")
    public void getKaptcha(HttpServletResponse response, HttpServletRequest request){
        //    生成验证码
        String accessCode= kaptchaProducer.createText();
        //    生成验证码图片
        BufferedImage image = kaptchaProducer.createImage(accessCode);
        //    将图片传入session
        HttpSession session = request.getSession();
        session.setAttribute(" accessCode", accessCode);
        //    将图片输出到前端(图片+格式)
        response.setContentType("image/png");
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            ImageIO.write(image, "png", outputStream);
        } catch (IOException e) {
            log.error("响应验证码失败", e);
        }
    }

    @GetMapping("/loginPage")
    @ApiOperation("登陆页面")
    public String login(){
        return "loginPage";
    }

    @GetMapping("/reg")
    @ApiOperation("注册页面")
    public String register(){
        return "reg";
    }


}
