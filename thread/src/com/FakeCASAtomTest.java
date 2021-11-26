package com;

//This is a fake code of CAS in order to simulate it
public class FakeCASAtomTest {
    private volatile static int count = 0;

    private synchronized static boolean CompareAndSet(int expect, int update){
        if(expect == count){
            count = update;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            new Thread(()->{
                ThreadUtils.sleep(50);
                boolean flag = false;
                //simulate self spin
                while (!flag){
                    flag = CompareAndSet(count, count+1);
                }
            }).start();
        }
        ThreadUtils.sleep(2000);
        System.out.println(count);
    }
}
