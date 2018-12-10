package com.zh.struct;

import java.util.EmptyStackException;

public class QStack<E> {

    private static final int DEFAULT_INIT_CAPACITY = 10;

    private Object[] elements;

    private int size;

    public QStack() {
        this(DEFAULT_INIT_CAPACITY);
    }


    public QStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }

        if (capacity > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("capacity > Integer.MAX_VALUE");
        }

        elements = new Object[capacity];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public E push(E e) {
        if (size >= elements.length) {
            grow();
        }

        elements[size] = e;
        size++;

        return e;
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }

        int len = size();

        E e = peek();
        size--;

        elements[len - 1] = null;

        return e;
    }

    public synchronized E peek() {
        int len = size();

        if (len == 0)
            throw new RuntimeException("stack is empty");

        return (E) elements[len - 1];
    }

    private void grow() {
        int oldCapacity = elements.length;
        Object[] old = elements;

        int newCapacity = oldCapacity * 2;
        elements = new Object[newCapacity];

        for (int i = 0; i < oldCapacity; i++) {
            elements[i] = old[i];
        }

        old = null;
    }

    public static void main(String[] args){
        QStack<String> stack = new QStack<>();
        stack.push("tom");
        stack.push("jim");
        stack.push("wendy");
        stack.push("natasha");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }


}
