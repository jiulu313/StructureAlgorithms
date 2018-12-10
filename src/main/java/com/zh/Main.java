package com.zh;

import com.zh.struct.QStack;

import java.util.Stack;

public class Main {
    public static void main(String[] args){

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
