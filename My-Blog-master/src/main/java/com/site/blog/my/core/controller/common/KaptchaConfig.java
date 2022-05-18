package com.site.blog.my.core.controller.common;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.google.code.kaptcha.util.Config;

import java.util.Properties;

import static com.google.code.kaptcha.Constants.KAPTCHA_OBSCURIFICATOR_IMPL;

@Component
public class KaptchaConfig {
    @Bean
    public DefaultKaptcha getDefaultKaptcha(){
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        // 初始化一个Propertis对象，设定验证码参数
        Properties properties = new Properties();
        // 设置边框，默认有  yes/no
        properties.put("kaptcha.border", "no");
        // 设置验证码文本字符颜色，默认为Color.BLACK
        properties.put("kaptcha.textproducer.font.color", "black");
        // 设置验证码图片宽度，默认为200
        properties.put("kaptcha.image.width", "150");
        // 设置验证码图片高度，默认为5
        properties.put("kaptcha.image.height", "40");
        // 验证码文本字符大小 默认为40
        properties.put("kaptcha.textproducer.font.size", "30");
        // KAPTCHA_SESSION_KEY
        properties.put("kaptcha.session.key", "verifyCode");
        // 验证码文本字符长度，默认为5
        properties.put("kaptcha.textproducer.char.space", "5");
        // 验证码文本字体样式，默认为new Font("Arial", 1, fontSize), new Font("Courier", 1, fontSize)
        properties.setProperty("kaptcha.textproducer.font.names", "Arial,Courier");
        // 图片样式 水纹com.google.code.kaptcha.impl.WaterRipple 鱼眼com.google.code.kaptcha.impl.FishEyeGimpy 阴影com.google.code.kaptcha.impl.ShadowGimpy
        properties.setProperty(KAPTCHA_OBSCURIFICATOR_IMPL, "com.google.code.kaptcha.impl.ShadowGimpy");
        // 配置其参数
        Config config = new Config(properties);
        // 使验证码参数生效
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}