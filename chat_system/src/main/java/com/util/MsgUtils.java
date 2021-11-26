package com.util;


import com.Messages;

import java.io.*;
import java.util.Optional;

public class MsgUtils {
    //read message from inputStream
    public static Optional<Messages> readMsg(InputStream inputStream){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(inputStream);
            //make to an Optional, to avoid null pin
            Messages message = (Messages) ois.readObject();
            return Optional.ofNullable(message);
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    //write message from outputStream
    public static void writeMsg(OutputStream outputStream, Messages messages){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(outputStream);
            oos.writeObject(messages);
            oos.flush();
        }catch (IOException  e) {
            e.printStackTrace();
        }

    }
}
