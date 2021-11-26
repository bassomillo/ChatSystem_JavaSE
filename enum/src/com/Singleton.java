package com;

public class Singleton {

    private Singleton(){

    }

    private enum SingletonHolder{
        INSTANCE;
        private Singleton instance;

        SingletonHolder() {
            this.instance = new Singleton();
        }
    }

    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE.instance;
    }

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance()==Singleton.getInstance());
    }
}
