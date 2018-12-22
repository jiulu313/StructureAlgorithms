package com.zh;


import com.zh.bean.Person;

import java.util.LinkedHashMap;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
//        testStack();
//        testCompare();

//        LinkedHashMap<String,String> map = new LinkedHashMap<>();
//
//        for (int i = 0; i < 10; i++) {
//            map.put("key" + i, "value" + i);
//        }
//
//        map.get("key" + 5);
//
//        for (String value : map.keySet()) {
//            System.out.println(value);
//        }

        System.out.println("hello,world");

    }

    private static void testCompare() {
        Person person1 = new Person("tom",23);
        Person person2 = new Person("jim",45);


        int r = person1.compareTo(person2);
        System.out.println(r);
    }

    private static void testStack() {
        //新建一个栈
        Stack<String> stack = new Stack<>();

        //分别向栈中添加不同的元素
        stack.push("tom");
        stack.push("jim");
        stack.push("wendy");
        stack.push("natasha");

        //分别弹栈
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }


}
