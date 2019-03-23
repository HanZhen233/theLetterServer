package com.hanzhen.theletterserver.dao;

import com.hanzhen.theletterserver.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Long> {

}
