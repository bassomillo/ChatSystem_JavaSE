package com;

public class Test {
    public static void print(Super<?> super1){
        for (int i = 0; i < super1.arrayLength(); i++) {
            System.out.println(super1.select(i));
        }
    }

    public static void main(String[] args) {

        Super<Student> superArray = new SuperArray<>();
        superArray.addToTail(new Student("zhangsan",12));
        superArray.addToTail(new Student("lisi",13));
        superArray.addToTail(new Student("wangwu",15));
        superArray.addToTail(new Student("zhaoliu",32));
//        superArray.addToHead("123");
//        superArray.addToHead("aaa");
//        superArray.addToHead("bbb");
        System.out.println(superArray.arrayToString());
        for (int i = 0; i < superArray.arrayLength(); i++) {
                Student student = (Student) superArray.select(i);
                student.play();


        }

        print(superArray);

    }
}
