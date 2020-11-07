package com.tiger.designpattern;


/**
 * command design pattern example
 *
 * decouple command receiver and invoker
 */
public class CommandPattern {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command cmd = new MyCommand(receiver);
        Invoker invoker = new Invoker(cmd);
        invoker.action();
    }

}

// command interface
interface Command {
    public void exe();
}

// command receiver
 class Receiver {
    public void action(){
        System.out.println("command received!");
    }
}

// command invoker
class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action(){
        command.exe();
    }
}

 class MyCommand implements Command {

    private Receiver receiver;

    public MyCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void exe() {
        receiver.action();
    }
}




