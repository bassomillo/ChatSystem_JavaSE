package com;

import com.strategyCodingMethod.User;

import java.util.Optional;
import java.util.Scanner;

public class OptionalTest {
    public static void main(String[] args) {
        User user = new User("bob",17,180.0);
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        if(a==0){
            user = null;
        }
        Optional<User> optionalUser = Optional.ofNullable(user);
        User aDefault = optionalUser.orElse(new User("default", 0, 0.0));
        System.out.println(aDefault.getUsername());

        User user1 = optionalUser.orElseGet(User::new);
        optionalUser.ifPresent(System.out::println);
        System.out.println("user1.toString() = " + user1.toString());
        optionalUser.orElseThrow(()->new RuntimeException("hahaha"));
    }
}
