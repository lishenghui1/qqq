package com.hhh.jjj;

import com.hhh.jjj.mapper.userMapper;
import com.hhh.jjj.po.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@MapperScan("com.hhh.jjj.mapper")
public class JjjApplication {



    public static void main(String[] args) {
        SpringApplication.run(JjjApplication.class, args);



    }

}
