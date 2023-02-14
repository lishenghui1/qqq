package com.hhh.jjj.controller;

import com.hhh.jjj.po.User;
import com.hhh.jjj.service.userService;

import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller

public class userController {

    @Autowired
    userService userservice;

    @RequestMapping("/hhhh")

    public String getuser() {
        return "index";
    }

    @RequestMapping("/login")

    public String login(User user, HttpSession session) {

        User user1 = userservice.select(user);

        if (user1 == null) {
            return "redirect:/hhhh";

        }
        session.setAttribute("user", user1);
        return "dashboard";
    }
}