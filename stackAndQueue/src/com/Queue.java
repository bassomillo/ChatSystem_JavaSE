package com;

import com.SuperArray.SuperArray;

public class Queue {
    //implement supperArray structure
    private SuperArray superArray = new SuperArray();

    //insert data in the tail of the array
    public void push(int data){
        superArray.addToTail(data);
    }

    //stretch data from the head of the array
    public int pop(){
        Integer select = superArray.select(0);
        superArray.delete(0);
        return select;
    }

    //read data from array
    public int peek(){
        return superArray.select(0);
    }
    public boolean isEmpty(){
        return superArray.arrayLength() == 0;
    }
}
