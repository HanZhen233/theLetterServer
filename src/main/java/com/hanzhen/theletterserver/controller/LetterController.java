package com.hanzhen.theletterserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/letter")
public class LetterController {
    @RequestMapping("/sendLetter")
    public boolean sendLetter(){
        
        return true;
    }
}
