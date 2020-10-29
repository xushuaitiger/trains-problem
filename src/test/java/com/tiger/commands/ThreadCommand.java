package com.tiger.commands;


public class ThreadCommand {

    public static void main(String[] args){
        Thread a = new Thread(new Worker());
        a.start();
        try {
            Thread.sleep(1000);
        }catch(Exception e){

        }
        System.out.println(a.toString());
    }


}

class Worker implements Runnable{
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }
}

class Worker2 implements Runnable{
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }
}
