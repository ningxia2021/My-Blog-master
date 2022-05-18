package com.site.blog.my.core.config;

import com.site.blog.my.core.interceptor.AdminLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class MyBlogWebMvcConfigurer implements WebMvcConfigurer {

    @Resource
    private AdminLoginInterceptor adminLoginInterceptor;

//    重写addInterceptors方法，addInterceptor方法是将拦截器注入到适配器中
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加一个拦截器，拦截以/admin为前缀的url路径
        // addPathPatterns方法是设置一个需要拦截的路径，可以是多个字符串或者是直接传入一个数组。
        registry.addInterceptor(adminLoginInterceptor).addPathPatterns("/admin/**").
                excludePathPatterns("/admin/login").excludePathPatterns("/admin/dist/**").
                excludePathPatterns("/admin/plugins/**");
    }

//    拦截静态资源
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").
                addResourceLocations("file:" + Constants.FILE_UPLOAD_DIC);
    }
}
