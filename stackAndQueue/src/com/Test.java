package com;

import com.SuperArray.SuperArray;

public class Test {
    public static void main(String[] args) {
        SuperArray superArray  = new SuperArray();
        Stack stack = new Stack(superArray);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        Queue queue = new Queue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());

    }
}
