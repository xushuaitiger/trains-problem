package com.tiger.designpattern;

/**
 * facade pattern
 */
public class FacadePattern {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.show();
    }
}

class Facade {
    private SubSystemA sa;
    private SubSystemB sb;
    private SubSystemC sc;

    public Facade() {
        sa = new SubSystemA();
        sb = new SubSystemB();
        sc = new SubSystemC();
    }

    public void show() {
        sa.show();
        sb.show();
        sc.show();
    }
}

class SubSystemA {
    public void show() {
        System.out.println("aaa");
    }
}

 class SubSystemB {
    public void show() {
        System.out.println("bbb");
    }
}

 class SubSystemC {
    public void show() {
        System.out.println("ccc");
    }
}

