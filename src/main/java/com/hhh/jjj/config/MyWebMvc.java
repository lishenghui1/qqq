//package com.hhh.jjj.config;
//
//import com.hhh.jjj.untils.LoginHandlerInterceptor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class MyWebMvc implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//        registry.addInterceptor(new LoginHandlerInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/","/login","/asserts/css/**","/asserts/img/**","/asserts/js/**");
//        // springmvc底层的拦截器没变 不改变springmvc的配置  进行额外自定义添加一个拦截器
//
//    }
//
//
//}
