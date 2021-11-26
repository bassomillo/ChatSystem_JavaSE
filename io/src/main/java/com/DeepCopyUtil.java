package com;

import java.io.*;

public class DeepCopyUtil {
    public static <T> T deepCopy(T t){
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        ByteArrayInputStream byteArrayInputStream = null;
        ObjectInputStream objectInputStream = null;
        T t1 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(t);
            byte[] bytes = byteArrayOutputStream.toByteArray();
            byteArrayInputStream = new ByteArrayInputStream(bytes);
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object o = objectInputStream.readObject();
            t1= (T) o;
            return t1;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if (byteArrayInputStream!=null){
                    byteArrayInputStream.close();
                }
                if(byteArrayOutputStream!=null){
                    byteArrayOutputStream.close();
                }
                if(objectInputStream!=null){
                    objectInputStream.close();
                }
                if (objectOutputStream!=null){
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;

    }
}
