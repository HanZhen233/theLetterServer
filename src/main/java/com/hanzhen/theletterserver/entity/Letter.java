package com.hanzhen.theletterserver.entity;


import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.List;


@Entity
@Table(name = "letter")
public class Letter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /*信件的id*/
    long letterId;
    /*发送者的id*/
    long senderId;
    /*接受者的id*/
    long receiverId;
    /*是否被人接收*/
    int status;
    @OneToMany(cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
    @JoinColumn(name = "letter_id")
    List<Message> messages;

    public long getLetterId() {
        return letterId;
    }

    public void setLetterId(long letterId) {
        this.letterId = letterId;
    }

    public long getSenderId() {
        return senderId;
    }

    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }

    public long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(long receiverId) {
        this.receiverId = receiverId;
    }

    public int  getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Letter(long senderId, int status, List<Message> messages) {
        this.senderId = senderId;
        this.status = status;
        this.messages = messages;
    }
}
