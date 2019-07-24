package com.xubao.test.simpleTest.java11;

import java.util.*;

public class SimpleTest {
    public static void main(String[] args) {
        varTest();
    }

    private static void streamTest() {
        List<String> list = Arrays.asList("1","2","3","4");
    }

    private static void varTest() {
        var s = "var Test";

        var arr = new ArrayList<String>();
        List<String> arr1 = new ArrayList<>();

        List<String> arr2 = arr;

        Map<String, String> map = new HashMap<>();

        var a = map.get("3");
        System.out.println(a);
    }
}
