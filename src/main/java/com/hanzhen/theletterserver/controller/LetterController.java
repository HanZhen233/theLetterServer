package com.hanzhen.theletterserver.controller;

import com.hanzhen.theletterserver.entity.Letter;
import com.hanzhen.theletterserver.entity.Message;
import com.hanzhen.theletterserver.service.impl.LetterServiceImpl;
import com.hanzhen.theletterserver.service.impl.UserDetailsImpl;
import com.hanzhen.theletterserver.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LetterController {
    @Resource
    LetterServiceImpl letterService;
    @Resource
    UserServiceImpl userService;
    /*随机发送邮件储存在数据库中*/
    @RequestMapping(value = "/sendLetter",method = RequestMethod.POST)
    public boolean sendLetter(@RequestParam("content") String content){
        /*获得登录者信息*/
        UserDetailsImpl securityUser=userService.getSecurityUser();
        Message message=new Message(0,content,securityUser.getUserId());
        List<Message>messages= new ArrayList<>();
        messages.add(message);
        /*根据相关信息形成邮件信息,发信人ID,0代表未被人收到,0代表未被人锁定*/
        Letter letter=new Letter(securityUser.getUserId(),0,messages);
        letterService.saveLetter(letter);
        return true;
    }
    /*随机锁定接受信件*/
        @RequestMapping(value = "/receiverLetter",method = RequestMethod.GET)
    public Letter receiverLetter(){
        /*获得登录者信息*/
        UserDetailsImpl securityUser=userService.getSecurityUser();
       Letter letter= letterService.getLetter();
       if (letter==null)
           return null;
       /*如果是自己的发的信则取消*/
       if (letter.getSenderId()==securityUser.getUserId()){
        return null;
       }
       letter.setReceiverId(securityUser.getUserId());
       letter.setStatus(1);
        letterService.saveLetter(letter);
        return letter;
    }
    /*当接受者拒接该信时，解锁该信*/
    @RequestMapping(value = "/unlockLetter",method = RequestMethod.POST)
    public boolean unlockLetter(@RequestParam("letterId") long letterId){
        UserDetailsImpl securityUser=userService.getSecurityUser();
        Letter letter=letterService.getLetterById(letterId);
        if (letter==null||letter.getReceiverId()!=securityUser.getUserId()){
            return false;
        }
        letter.setStatus(0);
        letterService.saveLetter(letter);
        return true;
    }
    @RequestMapping(value ="/getLetterList",method = RequestMethod.GET)
    public List<Letter> getLetterList(){
        UserDetailsImpl securityUser=userService.getSecurityUser();
        return letterService.getLetterList(securityUser.getUserId(),securityUser.getUserId());
    }

}
