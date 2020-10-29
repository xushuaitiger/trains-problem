package com.tiger.leetcode.cuncurrent;

import java.util.concurrent.CountDownLatch;

/**
 * 有三个线程t1、t2、t3。确保三个线程t1执行完后t2执行，t2执行完成后t3执行。
 */
public class OrderThreeThreads2 {
    public static void main(String[] args) {
        CountDownLatch c1 = new CountDownLatch(0);//计数器为0
        CountDownLatch c2 = new CountDownLatch(1);//计数器为1
        CountDownLatch c3 = new CountDownLatch(1);//计数器为1

        Thread t1 = new Thread(new Work(c1, c2), "线程t1");
        //c1为0，t1线程可以执行。t1线程的计数器 c2 减1

        Thread t2 = new Thread(new Work(c2, c3), "线程t2");
        //t1的计数器c2为0时，t2才能执行。t2的计数器c3减1

        Thread t3 = new Thread(new Work(c3, c3), "线程t3");
        //t3的计数器c3为0时，t3才能执行

        t1.start();
        t2.start();
        t3.start();
    }

    //定义Work线程类，需要传入开始和结束的CountDownLatch参数
    static class Work implements Runnable {
        private CountDownLatch c1;
        private CountDownLatch c2;

        public Work(CountDownLatch c1, CountDownLatch c2) {
            super();
            this.c1 = c1;
            this.c2 = c2;
        }

        @Override
        public void run() {
            try {
                //当某个线程调用CountDownLatch对象的await方法时，将会阻塞，直到计数器的值变成0才放行。
                c1.await();
                System.out.println("thread start:" + Thread.currentThread().getName());
                c2.countDown(); //本线程计数器减 1
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
