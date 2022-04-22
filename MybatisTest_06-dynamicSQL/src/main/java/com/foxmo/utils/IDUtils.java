package com.foxmo.utils;

import java.util.UUID;

public class IDUtils {
    public static String getID(){
        return String.valueOf(UUID.randomUUID()).replace("-","");
    }

/*    @Test
    public void test(){
        System.out.println(getID());
        System.out.println(getID());
        System.out.println(getID());
    }*/
}
