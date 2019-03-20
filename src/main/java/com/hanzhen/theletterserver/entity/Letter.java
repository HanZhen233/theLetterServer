package com.hanzhen.theletterserver.entity;


import javax.persistence.*;


@Entity
@Table(name = "letter")
public class Letter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long letterID;
    String sender;
    String receiver;
    String status;

    public long getLetterID() {
        return letterID;
    }

    public void setLetterID(long letterID) {
        this.letterID = letterID;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Letter(String sender, String receiver, String status) {
        this.sender = sender;
        this.receiver = receiver;
        this.status = status;
    }
}
