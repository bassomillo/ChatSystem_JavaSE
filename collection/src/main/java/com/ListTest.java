package com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
//        update();
//        delete();
//        set();
        List<String> arrayList1 = new ArrayList<>();
        arrayList1.add("a");
        arrayList1.add("b");
        arrayList1.add("b");
        arrayList1.add("b");
//        for (int i = 0; i < arrayList1.size(); i++) {
//            if("b".equals(arrayList1.get(i))){
//                arrayList1.remove(i);
//            }
//        }
        
//        for (int i = 0; i < arrayList1.size(); i++) {
//            if("b".equals(arrayList1.get(i))){
//                arrayList1.remove(i);
//                i--;
//            }
//        }
        
//        for (int i = arrayList1.size()-1; i > -1; i--) {
//            if("b".equals(arrayList1.get(i))){
//                arrayList1.remove(i);
//            }
//        }
        Iterator<String> iterator = arrayList1.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if("b".equals(next)){
                iterator.remove();
            }

        }
        System.out.println(arrayList1);

        
    }

    public static void update(){
        List<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        System.out.println(arrayList);
    }

    public static void delete(){
        List<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.remove("a");
        arrayList.remove(0);
        System.out.println(arrayList);
    }

    public static void set(){
        List<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.set(2,"e");
        System.out.println(arrayList);
    }

    public static void select(){
        List<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
       arrayList.get(2);
       arrayList.toString();
        System.out.println(arrayList);
    }
}
