package com;

public class Grandson extends Son{
    public String name = "Bob";
    public Grandson() {
        System.out.println("Grandson is created");
    }

    public void play(){
        this.eat();
        System.out.println(super.name+" grandson is playing");
    }
    public  void  eat(){
        System.out.println("grandson is eating");
    }
}
