package com.tiger.leetcode.cuncurrent;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    static class TaskThread extends Thread {

        CyclicBarrier barrier;

        public TaskThread(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                Thread.currentThread().setName("xushuaihu1");
                System.out.println(getName() + " 去读文件操作。。。");
                barrier.await(); //等待所有线程到达栅栏后执行下面代码
                System.out.println("xxx");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class TaskThread2 extends Thread {

        CyclicBarrier barrier;

        public TaskThread2(CyclicBarrier barrier) {
            this.barrier = barrier;
        }
        @Override
        public void run() {
            try {
                Thread.currentThread().setName("xushuaihu2");
                Thread.sleep(1000);
                System.out.println(getName() + " 去写文件操作。。。");
                barrier.await();//等待所有线程到达栅栏后执行下面代码
                Thread.sleep(1500);
                System.out.println("yyy");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    public static void main(String[] args) {
        //定义线程数2
        int threadNum = 2;

        //根据线程数实例化 栅栏
        CyclicBarrier barrier = new CyclicBarrier(threadNum, new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() +
                        " 完成最后任务");
            }
        });

        //开启读线程
        new TaskThread(barrier).start();
        //开启写线程
        new TaskThread2(barrier).start();
    }

}


