package com.hanzhen.theletterserver.service;

import com.hanzhen.theletterserver.entity.Letter;

import java.util.List;

public interface LetterService {
    public void saveLetter(Letter letter);
    public Letter getLetter();
    public Letter getLetterById(long id);
    public List<Letter> getLetterList(long id,long id1);
}
