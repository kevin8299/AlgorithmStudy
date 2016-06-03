package com.self_practices.cocurrent_study;

import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2016/5/13.
 */
public class VolatileTest {
//    volatile int count = 0;
//
//    class Mythread extends Thread{
//        public void run() {
//            while (true) {
//                System.out.println(Thread.currentThread().getName() + " " + count++);
//            }
//        }
//    }
//
//    Thread getThread(){
//        return new Mythread();
//    }

    public static volatile int count = 0;
    static Object ob = new Object();

    public static void inc() {

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
        }
        synchronized (ob) {
            count++;
        }
    }

    public static void main(String[] args) {

//        for (int i = 0; i < 1000; i++) {
//            new Thread(new Runnable() {
//                public void run() {
//                    VolatileTest.inc();
//                }
//            }).start();
//        }

        for (int i = 0; i < 100; i++) {
            new Thread(new MyThread()).start();
            System.out.println(i);
        }

        System.out.println("count = " + VolatileTest.count);
    }
}

class MyThread implements Runnable{
//    ReentrantLock lock = new ReentrantLock();
//    public void run() {
//        lock.lock();
//        VolatileTest.inc();
//        lock.unlock();
//    }
    Object ob = new Object();
    public void run() {
        synchronized (ob){
            VolatileTest.inc();
        }
    }

}