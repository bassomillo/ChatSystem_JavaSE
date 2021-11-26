package com.strategyCodingMethod;

public class CompareHeight implements Comparator1{

    @Override
    public Integer compare(User user1, User user2) {
        return (int) (user1.getHeight() - user2.getHeight());
    }
}
