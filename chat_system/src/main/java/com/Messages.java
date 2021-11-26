package com;

import java.io.Serializable;

public class Messages implements Serializable {

    private static final long serialVersionUID = 4497214422911483808L;
    private  Integer type;
    private  String content;
    private  String username;
    private  String password;
    private String friendUserName;

    public Messages(Integer toServer, String msg, String username, String friend) {
        this.type = toServer;
        this.content = msg;
        this.username = username;
        this.friendUserName = friend;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFriendUserName() {
        return friendUserName;
    }

    public void setFriendUserName(String friendUserName) {
        this.friendUserName = friendUserName;
    }


    public Messages() {

    }

    public String getUsername() {
        return username;
    }

    public Messages(String username, String password, Integer type) {
        this.type = type;
        this.password = password;
        this.username = username;
    }

    public Messages(Integer type, String content, String username) {
        this.type = type;
        this.content = content;
        this.username = username;
        //this.password = password;
        this.friendUserName = friendUserName;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "type=" + type +
                ", content='" + content + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", friendUserName='" + friendUserName + '\'' +
                '}';
    }
}
