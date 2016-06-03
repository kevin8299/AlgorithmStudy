package com.self_practices.cocurrent_study;

/**
 * Created by Administrator on 2016/5/13.
 */

/*
ThreadLocal is for storing per-thread state past the execution scope of a method.
Obviously local variables can't persist past the scope of their declaration.
If you needed them to, that's when you might start using a ThreadLocal.
*/
public class ThreadLocalTest {

//    public static void main(String[] args){
//        int data = 1;
//        new Thread(new MyRunnable("Hello1", data)).start();
//        new Thread(new MyRunnable("Hello2", data)).start();
//        new Thread(new MyRunnable("Hello3", data)).start();
//    }
//
//    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>(){
//        protected String initValue(){
//            return "hello";
//        }
//    };
//
//    static class MyRunnable implements Runnable{
//        private int num;
//        private String name;
//
//        public MyRunnable(String name, int num){
//            this.name = name;
//            this.num = num;
//        }
//
//        public void run(){
//            threadLocal.set(String.valueOf(num));
//            System.out.println(name + "  threadLocal value: " + threadLocal.get());
//            while(true){
//                num++;
////                System.out.println(name + "  " + num);
//                threadLocal.set(String.valueOf(num));
//                System.out.println(name + "  threadLocal value: " + threadLocal.get());
//
//                try {
//                    Thread.sleep(100);
//                }
//                catch(InterruptedException e){
//                    e.printStackTrace();
//                }
//            }
//        }
//    }


    public static ThreadLocal threadLocal = new ThreadLocal();

    public static void main(String[] args) {
        Runnable accumelatora = new Accumulatort();
        Thread threada = new Thread(accumelatora, "ThreadA");
        Thread threadb = new Thread(accumelatora, "ThreadB");
        threada.start();
        threadb.start();

    }
}
class Accumulatort implements Runnable {

    public void run() {
        ThreadLocal threadLocal = ThreadLocalTest.threadLocal;
        for (int i = 1; i <= 2; i++) {
            if (threadLocal.get() == null)
                threadLocal.set(new Integer(0));
            int x = ((Integer) threadLocal.get()).intValue();
            x += 1;
            threadLocal.set(new Integer(x));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread().getName() + "-->"
                    + ((Integer) threadLocal.get()).intValue());
        }
    }





}
