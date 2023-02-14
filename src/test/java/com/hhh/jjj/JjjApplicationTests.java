package com.hhh.jjj;

import com.hhh.jjj.mapper.productMapper;
import com.hhh.jjj.mapper.userMapper;
import com.hhh.jjj.po.Product;
import com.hhh.jjj.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class JjjApplicationTests {
    @Autowired
    productMapper usermapper;
    @Test
    void contextLoads() {
        List<Product> list = usermapper.selectList(null);
        System.out.println(list);
    }

}
