package com;

public class Son extends Father{
    //public String name = "Tom";

    public Son() {
        super("Ruilin");
    }

    public void work(){
        System.out.println(this.name+" is working");
    }
}
