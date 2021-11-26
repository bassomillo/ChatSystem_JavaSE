package com.templeteCodingMethod;

public abstract class Prisoners {
    protected  String name;
    abstract void work();
    abstract void eat();
    abstract void readNews();
    public void life(){
        eat();
        work();
        eat();
        work();
        eat();
        readNews();
    }
}
