package com.blz.addressbook;

import java.util.Scanner;

public class UserInput {
    private static Scanner sc = new Scanner(System.in);

    public static long getLong(){
        return sc.nextLong();
    }

    public static String getString(){
        return sc.next();
    }
}
