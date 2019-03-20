package com.hanzhen.theletterserver.dao;

import com.hanzhen.theletterserver.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByUserId(long id);
}
