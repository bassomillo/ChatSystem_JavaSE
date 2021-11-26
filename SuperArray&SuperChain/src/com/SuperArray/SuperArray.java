package com.SuperArray;

public class SuperArray {
    //initial Array
    private int[] element;
    private int currentIndex = -1;
    public SuperArray(){
        this(2);
    }
    public SuperArray(int capacity){
        element = new int[capacity];
    }
    //insert to the end
    public void  add(int index, int data){
        currentIndex++;
        if(currentIndex>=element.length-1){
            //expand the capacity
            int[] temp = new int[element.length*2];
            for (int i = 0; i < element.length; i++) {
                temp[i]=element[i];
            }
            element = temp;
        }
        for (int i = currentIndex; i >= index; i--) {
            element[i+1] = element[i];
        }
        element[index] = data;
    }

    //insert to the head
    public void addToHead(int data){
        this.add(0,data);
    }
    //insert to the end
    public void addToTail(int data){
        this.add(currentIndex+1,data);
    }

    //delete
    public void delete(int index){
        if(index<0||index>element.length-1){
            System.out.println("out of deleting range");
        }else {
            for (int i = index + 1; i < element.length; i++) {
                element[i - 1] = element[i];
            }
            currentIndex--;
        }
    }
    //set
    public void set(int index, int data){
        element[index] = data;
    }
    //search
    public Integer select(int index){
        if(index<0 || index>element.length-1){
            System.out.println("out of searching range");
            return null;
        }else {
            return element[index];
        }
    }

    //length of the array
    public int arrayLength(){
        return currentIndex+1;
    }

    public String arrayToString(){
        String res = "[";
        for (int i = 0; i <= currentIndex; i++) {
            res += element[i]+",";
        }
        return res.substring(0,res.length()-1)+"]";
    }

    public void sort(){
        for (int i = 0; i < currentIndex; i++) {
            for (int j = 0; j < currentIndex - i; j++) {
                if(element[j]>element[j+1]){
                    int temp = element[i];
                    element[i]=element[i+1];
                    element[i]=temp;

                }
            }
        }
    }
}
