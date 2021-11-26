package com.strategyCodingMethod;

import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
        User user1 = new User("a",12,155.6);
        User user2 = new User("b",14,185.6);
        User user3 = new User("c",13,175.6);
        User user4 = new User("d",4,50.4);
        User[] users = {user1,user2,user3,user4};
        UserSorter userSorter = new UserSorter();
        ComparaAge comparator1 = new ComparaAge();
        userSorter.sort(users, new CompareHeight());

        System.out.println(Arrays.toString(users));
    }
}
