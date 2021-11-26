package com;

//It can be seen that although volatile can make sure of the serialization and the data visible
//but it cannot make atom.
public class VolatileAtomTest {
    private volatile static int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            new Thread(()->{
                ThreadUtils.sleep(50);
                count++;
            }).start();
        }
        ThreadUtils.sleep(2000);
        System.out.println(count);
    }
}
