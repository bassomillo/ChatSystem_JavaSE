package com;

import java.util.Scanner;

public class ExeptionTest {
    public static void main(String[] args) {
        while (true){
            fun2();
        }
    }

    private static void fun2() {
        try {
            fun1();
        }catch (UserException e){
            throw new PasswordException(e);
        }catch (PasswordException exception){
            exception.printStackTrace();
            //System.out.println(exception.getCode());
            System.out.println("wrong password");
        }finally {
            System.out.println("The end");
        }
    }

    private static void fun1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input the user name");
        String username = scanner.next();
        if(!"admin".equals(username)){
            throw new UserException("wrong username",504);
        }
        System.out.println("please input the password");
        String password = scanner.next();
        if(!"123".equals(password)){
            throw new PasswordException();
        }
    }
}
