package com.zhifa.captcha.controller;

import com.ramostear.captcha.HappyCaptcha;
import com.ramostear.captcha.common.Fonts;
import com.ramostear.captcha.support.CaptchaStyle;
import com.ramostear.captcha.support.CaptchaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class HappyCaptchaController {

    @GetMapping("/captcha")
    public void captcha(HttpServletRequest req, HttpServletResponse res) {
        boolean finish = HappyCaptcha.require(req, res)
                .style(CaptchaStyle.IMG)            //设置展现样式为动画
                .type(CaptchaType.WORD_NUMBER_LOWER)            //设置验证码内容为汉字
                .length(4)                            //设置字符长度为6
                .width(220)                            //设置动画宽度为220
                .height(80)                            //设置动画高度为80
                //.font(Fonts.getInstance().zhFont())    //设置汉字的字体
                .build().finish();//生成并输出验证码
        Object attribute = req.getSession().getAttribute("happy-captcha");
        System.out.println(attribute);
    }
}
