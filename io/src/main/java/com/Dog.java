package com;

import java.io.Serializable;

public class Dog implements Serializable {

    private static final long serialVersionUID = 7487908803305354411L;
    private int age;

    public Dog(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @MyAnnotation(1)
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                '}';
    }
}
