package com.ay.config;

/**
 * @author Ay
 * @create 2019/09/15
 **/
public class Demo01 {

    static{
        System.out.print("a");
    }

    {
        System.out.print("b");
    }

    public static void main(String[] args) {
        Worker w1 = new Worker();
        Worker w2 = new Worker();
        Demo01 demo01 = new Demo01();
    }
}

class Worker extends Person{
    static {
        System.out.print("d");
    }

    {
        System.out.print("e");
    }

    public Worker(){
        System.out.print("f");
    }
}

class Person{

    static{
        System.out.print("g");
    }

    {
        System.out.print("h");
    }

    public Person(){
        System.out.print("i");
    }
}


