package com.hhh.jjj.service.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hhh.jjj.mapper.productMapper;
import com.hhh.jjj.mapper.userMapper;
import com.hhh.jjj.po.Product;
import com.hhh.jjj.po.User;
import com.hhh.jjj.service.productService;
import com.hhh.jjj.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public class productServiceimpl implements productService {
    @Autowired
    productMapper productmapper;

    @Override
    public Product selectone(int id) {
        return productmapper.selectById(id);
    }

    @Override
    public int delete(int id) {

        return productmapper.deleteById(id);
    }

    @Override
    public int update(Product product) {
        return productmapper.updateById(product);
    }

    @Override
    public int add(Product product) {

        return productmapper.insert(product);
    }

    @Override
    public List<Product> select() {
        return productmapper.selectList(null);
    }
}
