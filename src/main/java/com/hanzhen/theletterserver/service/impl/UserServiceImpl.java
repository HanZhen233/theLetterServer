package com.hanzhen.theletterserver.service.impl;

import com.hanzhen.theletterserver.dao.UserRepository;
import com.hanzhen.theletterserver.entity.User;
import com.hanzhen.theletterserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserByUserId(long id) {
        return userRepository.findByUserId(id);
    }

    @Override
    public User finUserByName(String name) {
        return userRepository.findByName(name);
    }
    @Override
    public void save(User user) {userRepository.save(user);}

    @Override
    public UserDetailsImpl getSecurityUser() {
        UserDetailsImpl securityUser=null;
        Object principal =  SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            securityUser   =((UserDetailsImpl )principal);
        }
        return securityUser;
    }

}
