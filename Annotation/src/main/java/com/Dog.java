package com;

import annotation.MyAnnotation;
import annotation.Singleton;

@Singleton
public class Dog {
    public int age;
    private String name;

    public Dog() {
    }

    private Dog(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @MyAnnotation(1)
    public void setName(String name) {
        this.name = name;
    }

    public void eat(String s){
        System.out.println("eating"+s);
    }

    private void eat(){
        System.out.println("eating");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
