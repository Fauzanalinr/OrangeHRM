package org.juaracoding;

public class Utils {
    static void delay(long detik){
        try{
            Thread.sleep(detik*1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    static void assertEqualsCustom(String actual, String expected){
        if(actual.equals(expected)){
            System.out.println("Passes");
        }else {
            System.out.println("Failed");
        }
    }

}
