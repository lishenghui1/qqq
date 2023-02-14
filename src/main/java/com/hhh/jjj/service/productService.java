package com.hhh.jjj.service;

import com.hhh.jjj.po.Product;
import com.hhh.jjj.po.User;

import java.util.List;

public interface productService {
    public  int  delete(int id);
    public  int  update(Product product);
    public  int  add(Product product);
    public List<Product> select();

    public  Product selectone(int id);

}
