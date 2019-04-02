package com.hanzhen.theletterserver.controller;

import com.hanzhen.theletterserver.entity.Letter;
import com.hanzhen.theletterserver.entity.Message;
import com.hanzhen.theletterserver.service.impl.LetterServiceImpl;
import com.hanzhen.theletterserver.service.impl.UserDetailsImpl;
import com.hanzhen.theletterserver.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class MessageController {
    @Resource
    UserServiceImpl userService;
    @Resource
    LetterServiceImpl letterService;
    @RequestMapping(value = "/sentMessage",method = RequestMethod.POST)
    public boolean sendMessage(@RequestParam("letterId")long letterId,
                               @RequestParam("content")String content){
        /*获取当前用户的相关信息*/
        UserDetailsImpl securityUser=userService.getSecurityUser();
        long senderId=securityUser.getUserId();
        Message message=new Message(0,content,senderId);
        Letter letter=letterService.getLetterById(letterId);
       letter.addMessage(message);
        letterService.saveLetter(letter);
        return true;
    }
}
