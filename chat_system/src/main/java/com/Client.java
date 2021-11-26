package com;

import com.constant.Constant;
import com.constant.MessageType;
import com.util.MsgUtils;
import com.util.ScannerUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Optional;

//send message to the server
//send message to friends
//broadcast message
public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(8888));
        //send message
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        System.out.println("Please log in");
        //indicate the user right now
        String username = null;
        //log in
        while (true){
            if(username==null){
                username = logIn(outputStream, inputStream);
            }else {
                printOrder();
                String input = ScannerUtil.input();
                switch (Integer.parseInt(input)){
                    case MessageType.TO_SERVER:
                        sendToServer(username,outputStream, inputStream);
                        break;
                    case MessageType.TO_FRIEND:
                        sendToFriend(username,outputStream, inputStream);
                        break;
                    case MessageType.TO_ALL:
                        sendToAll(username,outputStream, inputStream);
                        break;
                    case MessageType.RECEIVER:
                        receiveMsg(inputStream);
                    default:
                        break;
                }
            }

        }

//        outputStream.close();
//        socket.close();
    }

    private static void receiveMsg(InputStream inputStream) {
        while (true){
            Optional<Messages> messages = MsgUtils.readMsg(inputStream);
            messages.ifPresent(m-> System.out.println(m.getUsername()+":"+m.getContent()));
        }

    }

    private static void sendToAll(String username,OutputStream outputStream, InputStream inputStream) {
        boolean flag = true;
        while (flag){
            System.out.println(username+":");
            String msg = ScannerUtil.input();
            if("bye".equals(msg)) flag = false;
            MsgUtils.writeMsg(outputStream,new Messages(MessageType.TO_ALL,msg,username));
        }
    }

    private static void sendToFriend(String username,OutputStream outputStream, InputStream inputStream) {
        System.out.println("Please input the friend's name");
        String friend = ScannerUtil.input();
        boolean flag = true;
        while (flag){
            System.out.println(username+":");
            String msg = ScannerUtil.input();
            if("bye".equals(msg)) flag = false;
            MsgUtils.writeMsg(outputStream,new Messages(MessageType.TO_FRIEND,msg,username,friend));
        }

    }

    private static void sendToServer(String username,OutputStream outputStream, InputStream inputStream) {
        System.out.println(username+":");
        String msg = ScannerUtil.input();
        MsgUtils.writeMsg(outputStream,
                new Messages(MessageType.TO_SERVER,msg,username));
        //receive message
        Optional<Messages> messages = MsgUtils.readMsg(inputStream);
        messages.ifPresent(m-> System.out.println(m.getUsername()+":"+m.getContent()));
    }

    private static String logIn(OutputStream outputStream, InputStream inputStream) {
        System.out.println("please input username");
        String name = ScannerUtil.input();
        System.out.println("please input password");
        String password = ScannerUtil.input();
        Messages messages = new Messages();
        messages.setType(MessageType.LOG_IN);
        messages.setUsername(name);
        messages.setPassword(password);
        MsgUtils.writeMsg(outputStream, messages);
        //receipt message from server
        Optional<Messages> msg = MsgUtils.readMsg(inputStream);
        if (msg.isPresent()&& Constant.SUCCESS.equals(msg.get().getContent())){
            return name;
        }
        return null;
    }

    private static void printOrder(){
        System.out.println("please select the number:"
                +MessageType.TO_SERVER+". send to server  "
                + MessageType.TO_FRIEND +" sent to friend  "
                +MessageType.TO_ALL+" sent to all  "
                +MessageType.RECEIVER+" receive the message  ");
    }
}
