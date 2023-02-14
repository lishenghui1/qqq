package com.hhh.jjj.config;


import com.hhh.jjj.untils.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

@Configuration
public class MyAppConfig {   //可以负责 引入一些自定义的组件  到spring容器

    @Bean
    public LocaleResolver localeResolver(){
        return   new MyLocaleResolver();
    }

}
