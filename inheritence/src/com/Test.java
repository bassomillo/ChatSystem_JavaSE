package com;

public class Test {
    public static void main(String[] args) {
        Son son  = new Son();
        son.work();
        System.out.println(son.name);
        Grandson grandson = new Grandson();
        grandson.eat();
        grandson.play();
        System.out.println(son.name);
    }
}
