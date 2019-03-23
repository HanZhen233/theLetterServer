package com.hanzhen.theletterserver.dao;

import com.hanzhen.theletterserver.entity.Letter;
import com.hanzhen.theletterserver.service.LetterService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LetterRepository extends JpaRepository<Letter,Long> {
    List<Letter> findByStatus(int status);
    Letter findByLetterId(long id);
}
