package com;

public interface Super <T>{
    public void  add(int index, T data);

       void addToHead(T data);
       void addToTail(T data);
       void delete(int index);
       void set(int index, T data);
       Object select(int index);
       int arrayLength();
       String arrayToString();

    }
