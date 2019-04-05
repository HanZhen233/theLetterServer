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
    String  senderName;
    String  receiverName;
    int status;
    @OneToMany(cascade = {CascadeType.ALL})
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
    /*增加消息*/
    public  void addMessage(Message message){
        this.messages.add(message);
    }

    public Letter() {
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

//    public Letter(long senderId, int status, List<Message> messages) {
////        this.senderId = senderId;
////        this.status = status;
////        this.messages = messages;
////    }


    public Letter(long senderId, String senderName, int status, List<Message> messages) {
        this.senderId = senderId;
        this.senderName = senderName;
        this.status = status;
        this.messages = messages;
    }

    public Letter(long senderId, long receiverId, int status, List<Message> messages) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.status = status;
        this.messages = messages;
    }

    public Letter(long senderId, long receiverId, String senderName, String receiverName, int status, List<Message> messages) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.status = status;
        this.messages = messages;
    }
}
