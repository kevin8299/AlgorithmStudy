package com.self_practices.cocurrent_study;

import java.util.concurrent.Semaphore;

/**
 * Created by Administrator on 2016/5/13.
 */
public class SharedMemTest {
    public static void main(String[] args){
        Mythread myThread = new Mythread();
        myThread.getThread().start();
        myThread.getThread().start();
        myThread.getThread().start();
    }

}

class Mythread {
    int index = 0;
    Semaphore sem = new Semaphore(3);

    private class InnerThread extends Thread {

        //with synchronized implementation
        public synchronized void run1() {
            while (true) {
                System.out.println(Thread.currentThread().getName()
                        + " is running and index is " + index++);
                try {
                    Thread.sleep(10);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }

        //with semphore implementation
        public void run() {
            while(true) {
                if(sem.tryAcquire()){
                    try{
                        System.out.println(Thread.currentThread().getName()
                                + " is running and index is " + index++);
                        try {
                            Thread.sleep(10);
                        }
                        catch(InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    finally{
                        sem.release();
                    }
                }

            }
        }


    }

    public Thread getThread() {
        return new InnerThread();
    }
}