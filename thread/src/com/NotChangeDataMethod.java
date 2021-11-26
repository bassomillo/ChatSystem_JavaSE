package com;

public class NotChangeDataMethod {
    private static int number=0;
    private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i <100; i++) {
//                    System.out.println("t1 "+number++);
//                }
//            }
//        }).start();
//
//        new Thread(()->{
//            for (int i = 0; i < 100; i++) {
//                System.out.println("t2 "+number++);
//            }
//        }).start();

            new Thread(() -> {
                threadLocal.set(number);
                for (int i = 0; i <1000; i++) {
                    threadLocal.set(threadLocal.get()+1);
                    System.out.println("t1 "+threadLocal.get());
                }
            }).start();

        new Thread(()->{
            threadLocal.set(number);
            for (int i = 0; i < 1000; i++) {
                threadLocal.set(threadLocal.get()+1);
                System.out.println("t2 "+threadLocal.get());            }
        }).start();
    }

}
