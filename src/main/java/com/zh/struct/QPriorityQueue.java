package com.zh.struct;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 优先级队列
 */
public class QPriorityQueue<E> {
    //默认数组大小
    private static final int DEFAULT_INIT_CAPACITY = 10;

    //当前数组中存放元素的个数
    private int size;

    private Entry[] queue;


    public QPriorityQueue() {
        this(DEFAULT_INIT_CAPACITY);
    }

    public QPriorityQueue(int capacity) {
        //检查参数
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }

        //数组的第0位我们不用，从索引为1开始存，所以需要 capacity + 1
        queue = new Entry[capacity + 1];

        //当前队列中的元素个数为 0
        size = 0;
    }

    public void add(E e) {
        add(e, 0);
    }

    public void add(E e, int priority) {
        Entry entry = new Entry(e, priority);
        queue[size + 1] = entry;

        shiftUp(size + 1);

        size++;
    }

    public E poll(){
        Entry entry = queue[1];

        queue[1] = queue[size];
        size--;

        shiftDown(1);

        return (E) entry.e;
    }

    //添加使用shiftUp,向上翻
    private void shiftUp(int k) {
        while (k / 2 > 1) {
            if (queue[k].priority > queue[k / 2].priority) {
                swap(k, k / 2);
                k = k / 2;
            }
        }
    }

    //删除使用shiftDown,向下翻
    private void shiftDown(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j + 1 <= size && queue[j + 1].priority > queue[j].priority) {
                j = j + 1;
            }

            if(queue[j].priority <= queue[k].priority){
                break;
            }

            swap(k,j);

            k = j;
        }
    }

    private void swap(int i, int j) {
        Entry t = queue[i];
        queue[i] = queue[j];
        queue[j] = t;
    }

    static class Entry<E> {
        int priority;
        E e;

        public Entry(E e, int priority) {
            this.e = e;
            this.priority = priority;
        }

        public Entry(E e) {
            this.e = e;
            this.priority = 0;
        }

    }


    public static void main(String[] args) {
//
//        //比较两个任务，从大到小排序
//        Comparator<Task> comparator = new Comparator<Task>() {
//            @Override
//            public int compare(Task o1, Task o2) {
//                if (o1.priority > o2.priority) {
//                    return -1;
//                } else if (o1.priority == o2.priority) {
//                    return 0;
//                } else {
//                    return 1;
//                }
//            }
//        };
//
//        //新建一个任务
//        Queue<Task> priorityQueue = new PriorityQueue<Task>(10, comparator);
//
//        //新建了4个不同优先级的任务入队，数越大优先级越大，也最先执行
//        priorityQueue.add(new Task("task1", 23));
//        priorityQueue.add(new Task("task2", 34));
//        priorityQueue.add(new Task("task3", 15));
//        priorityQueue.add(new Task("task4", 79));
//
//        //分别取出任务，然后打印
//        System.out.println(priorityQueue.poll());   // 首先应该是 task4， 先取出来，因为优先级最大
//        System.out.println(priorityQueue.poll());   // 然后才是   task2   被取出来
//        System.out.println(priorityQueue.poll());   // 然后才是   task1   被取出来
//        System.out.println(priorityQueue.poll());   // 最后才是   task3   被取出来，因为优先级最小
    }

}
