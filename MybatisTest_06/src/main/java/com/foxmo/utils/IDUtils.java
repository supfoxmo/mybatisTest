package com.foxmo.utils;

import org.junit.jupiter.api.Test;
import org.omg.CORBA.StringHolder;

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
