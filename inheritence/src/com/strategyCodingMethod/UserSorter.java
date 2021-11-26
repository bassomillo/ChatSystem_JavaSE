package com.strategyCodingMethod;

public class UserSorter {
    public  void sort(User[] users, Comparator1 comparator){
        for (int i = 0; i < users.length; i++) {
            for (int j = 0; j < users.length - 1 - i; j++) {
                if (comparator.compare(users[j],users[j+1])>0){
                    User temp = users[j];
                    users[j] =users[j+1];
                    users[j+1] = temp;
                }
            }
        }
    }
}
