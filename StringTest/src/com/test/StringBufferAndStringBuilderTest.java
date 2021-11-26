package com.test;

public class StringBufferAndStringBuilderTest {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("d");
        stringBuilder.append("a").append("b").append("c").append("0.3");
        System.out.println(stringBuilder);
        stringBuilder.reverse();
        System.out.println(stringBuilder);
    }
}
