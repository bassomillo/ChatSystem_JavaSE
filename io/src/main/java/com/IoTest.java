package com;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

public class IoTest {

    @Test
    public void creatFileTest() throws IOException {
        File file = new File("D:/code/a.txt");
        System.out.println("file = " + file);
        boolean newFile = file.createNewFile();
        File parent = new File("D:/code1");
        File file1 = new File(parent,"b.txt");
        parent.mkdir();
        file1.createNewFile();
        if(!file.exists()){
            System.out.println("file not found");
        }
        if(file.exists()){
            boolean delete = file.delete();
            System.out.println(delete?"delete success":"delete failed");
        }
    }
    @Test
    public void findAllImgTest(){
        findAllImg("D:\\picture");
    }

    public void findAllImg(String path){
        File file = new File(path);
        File[] files = file.listFiles((p, n) -> new File(p, n).isDirectory() || n.contains("png") || n.contains("jpg"));
        for (File file1 : files) {
            if(file1.isDirectory()){
                findAllImg(file1.toString());
            }
            else {
                System.out.println(file1.getName());
            }
        }
    }

    @Test
    public void ioReadTest() throws IOException {
        File file = new File("D:\\code1\\b.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        int len;
        byte[] bytes = new byte[3];
        StringBuilder stringBuilder = new StringBuilder();
        while ((len = fileInputStream.read(bytes))!=-1){
            String s = new String(bytes, 0, len);
            stringBuilder.append(s);
        }
        System.out.println(stringBuilder);
    }

    @Test
    public void ioWriteTest() throws IOException {
        File file = new File("D:\\code1\\b.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file,true);
        fileOutputStream.write("hello write stream".getBytes());


    }

    @Test
    public void copyFileTest(){
        File file;
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            file = new File("C:\\Users\\bassomillo\\Videos\\movie\\a.avi");
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream("D:\\code1\\b.avi");
            //set a buf to make the copy faster
            byte[] buf = new byte[1024 * 1024];
            long l = System.currentTimeMillis();
            int len;
            while ((len = fileInputStream.read(buf)) != -1) {
                fileOutputStream.write(buf, 0, len);
            }
            long r = System.currentTimeMillis();

            System.out.println(r - l);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void ioCopyTest2(){
        try (
             FileInputStream fileInputStream = new FileInputStream("C:\\Users\\bassomillo\\Videos\\movie\\a.avi");
             FileOutputStream fileOutputStream = new FileOutputStream("D:\\code1\\b.avi")){
            //set a buf to make the copy faster
            byte[] buf = new byte[1024 * 1024];
            long l = System.currentTimeMillis();
            int len;
            while ((len = fileInputStream.read(buf)) != -1) {
                fileOutputStream.write(buf, 0, len);
            }
            long r = System.currentTimeMillis();

            System.out.println(r - l);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readerTest() throws IOException {
        FileReader fileReader = new FileReader("D:/code/a.txt");
        FileWriter fileWriter = new FileWriter("D:/code1/b.txt");
        int b;
        while((b=fileReader.read())!=-1){
            fileWriter.write(b);
        }
        fileWriter.close();
        fileReader.close();
    }

    @Test
    public void bufferReaderTest() throws IOException {
        FileReader fileReader = new FileReader("D:/code1/b.txt");

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String content;
        while ((content = bufferedReader.readLine())!=null){
            System.out.println(content);
            System.out.println("-----------");
        }
        bufferedReader.close();
        fileReader.close();


    }

    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("D:/code1/b.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        while (true){
            Scanner scanner = new Scanner(System.in);
            String next = scanner.next();
            bufferedWriter.write(next);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
    }

    @Test
    public void serializationTest() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("D:/code1/c.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(new User(12));
        objectOutputStream.close();
        fileOutputStream.close();
    }

    @Test
    public void deserializationTest() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("D:/code1/c.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        User user = (User) objectInputStream.readObject();
        fileInputStream.close();
        objectInputStream.close();
        System.out.println(user.toString());

    }

    @Test
    public void lightCopyTest() throws CloneNotSupportedException {
        User user = new User(12);
        user.setDog(new Dog(2));
        User user1 = (User) user.clone();
        user.getDog().setAge(3);
        user.setAge(13);
        System.out.println(user1.getDog().getAge());
    }

    @Test
    public void deepCopyTest(){
        User user = new User(12);
        user.setDog(new Dog(2));
        User user1 = DeepCopyUtil.deepCopy(user);
        user.getDog().setAge(3);
        user.setAge(13);
        System.out.println("user = " + user);
        System.out.println("user1 = " + user1);
    }



    }
