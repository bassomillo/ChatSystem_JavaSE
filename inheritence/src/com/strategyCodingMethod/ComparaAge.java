package com.strategyCodingMethod;

public class ComparaAge implements Comparator1{
    public Integer compare(User user1, User user2){
        return user1.getAge()-user2.getAge();

    }

}
