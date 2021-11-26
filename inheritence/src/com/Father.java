package com;

public class Father {
    public Father() {
        this.name = "Jerry";
        System.out.println("father is created");
    }
    public Father(String name){
        this.name = name;
    }

    public String name = "lily";
    public void eat(){
        System.out.println("father is eating");
    }
}
