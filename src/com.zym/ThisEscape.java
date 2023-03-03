package com.zym;

/**
 * @author zhouyumeng
 * @date 2023/01/18
 **/
public class ThisEscape {

    public ThisEscape () {

        new EventListener() {
            public void onEvent() {
                System.out.println(this);
            }
        }.onEvent();

    }

    public static void main(String[] args) {
        new ThisEscape();
    }

    @Override
    public String toString() {
        return "ThisEscape{}";
    }
}
