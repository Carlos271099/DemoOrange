package org.example.utils;

public class Delay {

    public static void delay(long delay){
        try {
            Thread.sleep(delay);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}
