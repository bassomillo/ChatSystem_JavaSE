package com;

import com.SuperArray.SuperArray;

//first input, last out
public class Stack {
    public Stack(SuperArray superArray) {
        this.superArray = superArray;
    }

    //implement supperArray structure
    private SuperArray superArray;

    //insert data in the tail of the array
    public void push(int data){
        superArray.addToTail(data);
    }

    //stretch data from the head of the array
    public int pop(){
        Integer select = superArray.select(superArray.arrayLength()-1);
        superArray.delete(superArray.arrayLength()-1);
        return select;
    }

    //read data from array
    public int peek(){
        return superArray.select(superArray.arrayLength()-1);
    }
    public boolean isEmpty(){
        return superArray.arrayLength() == 0;
    }
}
