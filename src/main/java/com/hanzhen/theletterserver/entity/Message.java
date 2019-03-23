package com.hanzhen.theletterserver.entity;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long messageId;
    Timestamp timestamp;
    int status;
    @Column(length = 2000)
    String content;
    long senderId;
    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public long getSenderId() {
        return senderId;
    }

    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }

    public Message(int status, String content, long senderId) {
        this.status = status;
        this.content = content;
        this.senderId = senderId;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public Message(int status, String content) {
        this.status = status;
        this.content = content;
    }

}
