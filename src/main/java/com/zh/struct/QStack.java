package com.zh.struct;


public class QStack<E> {
    //数组的默认大小为10
    private static final int DEFAULT_INIT_CAPACITY = 10;

    //底层的数组
    private Object[] elements;

    //栈中的个数
    private int size;

    public QStack() {
        this(DEFAULT_INIT_CAPACITY);
    }


    public QStack(int capacity) {
        //capacity条件检查 ，这里我们直接抛出异常
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }

        if (capacity > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("capacity > Integer.MAX_VALUE");
        }

        //新建一个capacity大小的数组
        elements = new Object[capacity];

        //初始个数为0
        size = 0;
    }

    //栈是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //返回栈中的元素个数
    public int size() {
        return size;
    }

    //将一个元素压入栈中
    public E push(E e) {
        //如果栈已满，进行扩容
        if (size >= elements.length) {
            grow();
        }

        //扩容完后将元素e压入栈中
        elements[size] = e;

        //别忘了size需要加 1
        size++;

        return e;
    }

    //出栈，就是将数组最后一个元素弹出
    public E pop() {
        //如果栈为空就返回null
        if (isEmpty()) {
            return null;
        }

        //拿到栈的大小
        int len = size();

        //把数组中最后一个元素保存起来
        E e = peek();
        //个数别忘了减1
        size--;

        //将最后一个元素置null
        elements[len - 1] = null;

        //返回e
        return e;
    }

    //返回最后一个元素
    public E peek() {
        int len = size();

        if (len == 0)
            throw new RuntimeException("stack is empty");

        return (E) elements[len - 1];
    }

    //扩容
    private void grow() {
        //将之前的数组保存
        int oldCapacity = elements.length;
        Object[] old = elements;

        //新的数组大小为原来数组大小的2倍
        int newCapacity = oldCapacity * 2;
        //再新建一个大小为原来数组2倍的新数组
        elements = new Object[newCapacity];

        //把以前的老的数组中的元素都移动新数组中
        for (int i = 0; i < oldCapacity; i++) {
            elements[i] = old[i];
        }

        //释放以前的内存空间
        old = null;
    }


    public static void main(String[] args){
//        QStack<String> stack = new QStack<>();
//        stack.push("tom");
//        stack.push("jim");
//        stack.push("wendy");
//        stack.push("natasha");
//
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
    }

}
