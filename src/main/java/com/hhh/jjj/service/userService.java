package com.hhh.jjj.service;

import com.hhh.jjj.po.User;

public interface userService {
    public  int  delete(User user);
    public  int  update(User user);
    public  int  add(User user);
    public  User select(User user);


}
