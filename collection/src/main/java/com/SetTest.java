package com;

import java.util.*;

//disorder and not the same
public class SetTest {
    public static void main(String[] args) {
//        test();
//        ListToSet();
        Set<String> strings = new HashSet<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        strings.add("d");
        strings.add("d");
        strings.add("f");
        strings.add("g");
        strings.add("g");
        strings.add("h");
        strings.add("i");
        strings.add("j");
        strings.add("k");
        strings.add("l");
        strings.add("m");
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }

        for (String string : strings) {
            System.out.println(string);
        }
        
    }

    private static void test(){
        Set<String> strings = new HashSet<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        strings.add("d");
        strings.add("d");
        strings.add("f");
        strings.add("g");
        strings.add("g");
        strings.add("h");
        strings.add("i");
        strings.add("j");
        strings.add("k");
        strings.add("l");
        strings.add("m");
        System.out.println(strings);



    }

    private static void ListToSet(){

        List<String> stringList= new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("d");
        stringList.add("d");
        stringList.add("d");
        stringList.add("f");
        stringList.add("g");
        stringList.add("g");
        stringList.add("h");
        stringList.add("i");
        stringList.add("j");
        stringList.add("k");
        stringList.add("l");
        stringList.add("m");
        Set<String> strings = new HashSet<>();
        strings.addAll(stringList);
        stringList.removeAll(stringList);
        stringList.addAll(strings);
        System.out.println(stringList);
    }
}
