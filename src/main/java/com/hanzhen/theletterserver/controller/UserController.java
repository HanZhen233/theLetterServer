package com.hanzhen.theletterserver.controller;

import com.hanzhen.theletterserver.entity.Role;
import com.hanzhen.theletterserver.entity.User;
import com.hanzhen.theletterserver.service.impl.RoleServiceImpl;
import com.hanzhen.theletterserver.service.impl.UserDetailsImpl;
import com.hanzhen.theletterserver.service.impl.UserServiceImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Resource
    UserServiceImpl userService;
    @Resource
    RoleServiceImpl roleService;
    @RequestMapping(value = "login1")
    public  String login(){
        return "登录成功";
    }
    /*登录成功返回其他个人数据*/
    @RequestMapping(value = "/logined")/*返回个人信息*/
    public User hello(){
        UserDetailsImpl securityUser=userService.getSecurityUser();
        User user=new User();
        user.setUserId(securityUser.getUserId());
        user.setName(securityUser.getUsername());
        user.setGender(securityUser.getGender());
//        user.setPhone(securityUser.getPhone());
        user.setEmail(securityUser.getEmail());
        return    user;
    }
    /**/
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public boolean addUser(@RequestParam("username")String username, @RequestParam("password")String password,
//                           @RequestParam("phone") String phone,
                           @RequestParam("gender") int gender,
                           @RequestParam("email") String email){

        if (userService.finUserByName(username)!=null){
            return false;
        }
        Role role=roleService.findById(1);
        List<Role> roles= new ArrayList<>();
        roles.add(role);
        System.out.println(role.getName());
        User user=new User(username,password,email,gender,roles);
        userService.save(user);
        return true;
    }
//    @RequestMapping(value = "/test")
//    public boolean test(){
//        Role role=roleService.findById(1);
//        List<Role> roles= new ArrayList<>();
//        roles.add(role);
//        User user=new User("test","test","test",0,roles);
//        userService.save(user);
//        return true;
//    }
}
