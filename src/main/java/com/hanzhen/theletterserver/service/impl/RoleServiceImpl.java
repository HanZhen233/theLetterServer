package com.hanzhen.theletterserver.service.impl;

import com.hanzhen.theletterserver.dao.RoleRepository;
import com.hanzhen.theletterserver.entity.Role;
import com.hanzhen.theletterserver.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Role findById(int id) {
        return roleRepository.findById(id);
    }
}
