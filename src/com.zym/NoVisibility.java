package com.zym;

import java.util.Collections;
import java.util.Vector;

/**
 * @author zhouyumeng
 * @date 2023/02/06
 **/
public class NoVisibility {

    private static boolean ready;
    private static int number;

    private static class ReaderThread implements Runnable {
        @Override
        public void run() {
            while (!ready) {
                System.out.println(ready);
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().run();
        number = 42;
        ready = true;
    }

}
