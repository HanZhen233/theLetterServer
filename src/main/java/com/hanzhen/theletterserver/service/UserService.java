package com.hanzhen.theletterserver.service;

import com.hanzhen.theletterserver.entity.User;

public interface UserService {
    /*根据用户ID查询用户*/
    public User findUserByUserId(long id);
    public void save(User user);
}
