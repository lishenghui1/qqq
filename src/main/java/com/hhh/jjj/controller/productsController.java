package com.hhh.jjj.controller;

import com.hhh.jjj.po.Product;
import com.hhh.jjj.po.User;
import com.hhh.jjj.service.productService;
import com.hhh.jjj.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

;import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Controller

public class productsController {

@Autowired
    productService productservice;
 @Autowired
    StringRedisTemplate stringRedisTemplate;
 @Autowired
    RedisTemplate<String,Product> redisTemplate;
    @Autowired
    RedisTemplate<String,Object> redisTemplate1;
    @RequestMapping("/products")

    public String tolist(Model model) {
        if(redisTemplate.hasKey("product")){
            List<Product> product = redisTemplate.opsForList().range("product", 0, -1);
            model.addAttribute("list",product);
        }else {
            List  product = productservice.select();
            redisTemplate.opsForList().leftPushAll("product",product);
            redisTemplate.expire("product",1, TimeUnit.DAYS);
            model.addAttribute("list",product);
        }
        return "list";
    }

    @DeleteMapping("/product/{id}")
    public String delectProduct(Model model,@PathVariable int id) {
        productservice.delete(id);
        return "redirect:/products";

    }
    @PutMapping("/product/{id}")
    public String toupdateProduct(Model model,@PathVariable int id) {
        Product pr = productservice.selectone(id);
        model.addAttribute("product",pr);
        model.addAttribute("msg","/update");
        return "addandupdate";

    }
    @RequestMapping("/update")
    public String updateProduct(Model model,Product product) {

        productservice.update(product);
        return "redirect:/products";

    }
    @RequestMapping("/toadd")
    public String toaddProduct(Model model,Product product) {

        model.addAttribute("msg","/add");
        return "addandupdate";

    }
    @RequestMapping("/add")
    public String addProduct(Model model,Product product) {
        System.out.println(product);

        productservice.add(product);
        redisTemplate1.opsForValue().set("pro"+product.id,product);
        Product o = (Product)redisTemplate1.opsForValue().get("pro" + product.id);

        System.out.println(o.name);

        return "redirect:/products";

    }
}