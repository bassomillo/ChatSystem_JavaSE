package com;

import com.constant.Constant;
import com.constant.MessageType;
import com.util.MsgUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;


public class ServerThread extends Thread{
    public static  final Map<String, Socket> USERS = new ConcurrentHashMap<>(8);
    private Socket socket;
    public ServerThread(Socket socket){
        this.socket = socket;
    }

    public ServerThread() {
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        OutputStream outputStream = null;
        try {
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true){
            Optional<Messages> message =  MsgUtils.readMsg(inputStream);
            if(message.isPresent()){
                Messages messages = message.get();
                switch (messages.getType()){
                    case MessageType.LOG_IN:
                        loginHandler(inputStream,outputStream,messages,socket);
                        break;
                    case MessageType.TO_SERVER:
                        sendToClient(inputStream,outputStream,messages);
                        break;
                    case MessageType.TO_FRIEND:
                        sendToTarget(messages);
                        break;
                    case MessageType.TO_ALL:
                        sendToAll(messages);
                        break;
                }
            }


        }
    }

    private void sendToAll(Messages messages) {
        for(Map.Entry<String,Socket> entry : USERS.entrySet()){
            Socket socket = entry.getValue();
            try {
                MsgUtils.writeMsg(socket.getOutputStream(), messages);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void sendToTarget(Messages messages) {
        Socket socket = USERS.get(messages.getFriendUserName());
        try {
            MsgUtils.writeMsg(socket.getOutputStream(), messages);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendToClient(InputStream inputStream, OutputStream outputStream,Messages messages) {
        System.out.println(messages.getUsername()+": "+messages.getContent());
        MsgUtils.writeMsg(outputStream,new Messages(MessageType.FROM_SERVER, Constant.OK, Constant.SERVER_NAME));
    }

    private void loginHandler(InputStream inputStream, OutputStream outputStream, Messages message,Socket socket) {
        //logic of login
        if(!Constant.DEFAULT_PASSWORD.equals(message.getPassword()) || message.getUsername() == null){
            MsgUtils.writeMsg(outputStream, new Messages(MessageType.FROM_SERVER, Constant.FAIL,Constant.SERVER_NAME));

        }
        else {
            //if login successfully then put it into Map
            USERS.put(message.getUsername(), socket);
            System.out.println(message.getUsername()+" login successfully");
            MsgUtils.writeMsg(outputStream, new Messages(MessageType.FROM_SERVER,Constant.SUCCESS ,Constant.SERVER_NAME));

        }

    }
}
