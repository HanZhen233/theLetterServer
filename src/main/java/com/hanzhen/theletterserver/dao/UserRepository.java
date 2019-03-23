package com.hanzhen.theletterserver.dao;

import com.hanzhen.theletterserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserId(long id);
    User findByName(String name);
}
