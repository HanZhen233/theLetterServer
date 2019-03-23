package com.hanzhen.theletterserver.dao;

import com.hanzhen.theletterserver.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    public Role findByName(String name);
    public  Role findById(int id);
}
