package com.SuperChain;

public class Test {
    public static void main(String[] args) {
        SuperLink superLink = new SuperLink();
//        superLink.addToTail(22);
//        superLink.addToTail(23);
//        superLink.addToTail(24);
//        superLink.add(1,35);
//        superLink.delete(1);
//        superLink.delete(1);
        //Add to tail is much slower than add to head
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 10000; i++) {
//            superLink.addToHead(i);
//        }
//        long end = System.currentTimeMillis();
//        System.out.println(end-start);
//
//
//        SuperLink superLink1 = new SuperLink();
//        for (int i = 0; i < 7000; i++) {
//            superLink1.addToHead((int) (Math.random()*10000));
//        }
//        long start1 = System.currentTimeMillis();
//        superLink1.sort2();
//        long end1 = System.currentTimeMillis();
//
//        System.out.println(superLink1.arrayToString());
//        System.out.println(end1-start1);
        SuperLink superLink2 = new SuperLink();
        superLink2.addToHead(1);
        superLink2.addToHead(2);
        superLink2.addToHead(3);
        superLink2.addToHead(4);
        superLink2.addToHead(5);
        System.out.println(superLink2.arrayToString());
        Node head = superLink2.selectNode(0);
        Node reverse = superLink2.reverse(head);
        System.out.println(reverse.getData());
        System.out.println(reverse.getNext().getData());
//
        System.out.println(reverse.getNext().getNext().getData());
        System.out.println(reverse.getNext().getNext().getNext().getData());
        System.out.println(reverse.getNext().getNext().getNext().getNext().getData());
//        System.out.println(reverse.getNext().getNext().getNext().getNext().getNext().getData());
        System.out.println("superLink2.arrayToString() = " + superLink2.arrayToString());
    }
}
