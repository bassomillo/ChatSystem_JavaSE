package com;

import java.io.Serializable;

public class User implements Serializable,Cloneable{
    private static final long serialVersionUID = 663490687204099044L;
    public String name;
    private int age;
    private Dog dog;

    public User() {
    }

    public User(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog getDog() {
        return dog;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dog=" + dog +
                '}';
    }
}
