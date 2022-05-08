package com.urize.my_test;

public class ArrayTestMain {
    static String[] someString = new String[10];

    public static void main(String[] args) {
        someString[0] = "lll";
        someString[1] = "mmm";
        someString[2] = "nnn";
        System.out.println(showIndex("lll"));
    }

    private static int showIndex(String uui) {
        int index = 0;
        for (int i = 0; i < someString.length; i++) {
            if (someString[i].equals(uui)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
