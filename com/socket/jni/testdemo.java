package com.socket.jni;

public class testdemo {
    static {
        System.loadLibrary("hello");
    }

public static native String sayYes(String name);

    public static void main(String[] args) {
        String name = "xianfa";
        String text = sayYes(name);
        System.out.println("after namtive,java shows" + ":" + text);
    }
}
