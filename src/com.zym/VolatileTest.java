package com.zym;

/**
 * @author zhouyumeng
 * @date 2023/01/19
 **/
public class VolatileTest {

     int a = 1;
     int b = 2;

    public void change(){
        a = 3;
        b = a;
    }

    public void print(){
        System.out.println("b=" + b + ";a=" + a);
    }

    public static void main(String[] args) {
        //可能出现的结果 b=2;a=1 b=3;a=3 b=2;a=3
        //会出现 b=3;a=1
        //b=3;a=1 线程1修改了a，对线程2是不可见的
        //b=2;a=3/b=2;a=1 不能百分百确定没有可见性问题
        while (true){
            final VolatileTest test = new VolatileTest();
            new Thread(() -> {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test.change();
            }).start();
            new Thread(() -> {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test.print();
            }).start();
        }
    }
}
