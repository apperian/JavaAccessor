package com.apperian.javautil;

public class Accessor {
    
    static {
        System.loadLibrary("accessor");
    }
    
    public static native Object invoke();
}
