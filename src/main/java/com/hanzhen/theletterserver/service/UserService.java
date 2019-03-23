package com.hanzhen.theletterserver.service;

import com.hanzhen.theletterserver.entity.User;
import com.hanzhen.theletterserver.service.impl.UserDetailsImpl;

public interface UserService {
    /*根据用户ID查询用户*/
    public User findUserByUserId(long id);
    /*根据用户名称查询用户*/
    public User finUserByName(String name);
    /*保存用户*/
    public void save(User user);
    /*得到验证过后的用户信息*/
    public UserDetailsImpl getSecurityUser();
}
