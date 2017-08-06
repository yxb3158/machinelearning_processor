package com.xidian.ml.java.threadPool.demo;

/**
 * Created by yxb on 2017/8/6.
 */
public class SynchronizedDemo {
    private static class Counter {

//        public synchronized void count() {
//            for (int i = 0; i < 10; i++) {
//                System.out.println(Thread.currentThread().getName() + "   i==" + i);
//            }
//        }

        public  void count() {
            synchronized(this){
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "   ii==" + i);
                }

            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "   j==" + i);
            }
            }

        }

    }

    private static class MyThread extends Thread {
        private Counter myCounter;

        public MyThread(Counter counter) {
            this.myCounter = counter;

        }

        public void run() {
            super.run();
            myCounter.count();
        }


    }

    public static void main(String [] var0){
        Counter counter=new Counter();
        MyThread myThread1 = new MyThread(counter);
        MyThread myThread2 = new MyThread(counter);

        myThread1.start();
        myThread2.start();

    }
}
