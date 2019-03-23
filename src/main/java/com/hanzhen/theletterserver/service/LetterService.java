package com.hanzhen.theletterserver.service;

import com.hanzhen.theletterserver.entity.Letter;

public interface LetterService {
    public void saveLetter(Letter letter);
    public Letter getLetter();
    public Letter getLetterById(Long id);
}
