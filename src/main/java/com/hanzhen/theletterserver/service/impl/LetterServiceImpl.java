package com.hanzhen.theletterserver.service.impl;

import com.hanzhen.theletterserver.dao.LetterRepository;
import com.hanzhen.theletterserver.entity.Letter;
import com.hanzhen.theletterserver.service.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class LetterServiceImpl implements LetterService{
    @Autowired
    LetterRepository letterRepository;
    /*保存信件*/
    @Override
    public void saveLetter(Letter letter) {
        letterRepository.save(letter);
    }

    @Override
    public Letter getLetter() {
        /*找到随机的未被接受的信*/
       List<Letter> letters=letterRepository.findByStatus(0);
       if (letters.size()==0)
           return null;
        Random random=new Random();
        int i=random.nextInt(letters.size());
        return letters.get(i);
    }

    @Override
    public Letter getLetterById(long id) {
        return letterRepository.findByLetterId(id);
    }

    @Override
    public List<Letter> getLetterList(long id,long id1) {
        return letterRepository.findBySenderIdOrReceiverId(id,id1);
    }
}
