package com.geekaca.testthread.homework;

import java.util.LinkedList;

/**
 * 生产者消费者
 * 了解
 */
public class ProducerConsumerExample {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(5); // 缓冲区大小为5  5个盘子

        // 创建生产者线程和消费者线程
        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));

        // 启动线程
        producerThread.start();
        consumerThread.start();
    }
}

// 缓冲区类   盘子
class Buffer {
    //频繁对集合数据 增加，删除
    private LinkedList<Integer> buffer; // 缓冲区
    private int maxSize; // 缓冲区最大大小

    public Buffer(int maxSize) {
        this.maxSize = maxSize;
        buffer = new LinkedList<>();
    }

    // 生产者向缓冲区中放入数据
    public synchronized void produce(int num) {
        while (buffer.size() == maxSize) {
            try {
//                厨师进入等待
                wait(); // 缓冲区已满，等待消费者消费
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        buffer.add(num);
        System.out.println("生产者生产：" + num);
        //厨师做一个菜放入盘子，就按一下铃，通知一下顾客
        notifyAll(); // 通知消费者可以消费
    }

    // 消费者从缓冲区中取出数据
    public synchronized int consume() {
        while (buffer.isEmpty()) {
            try {
                //顾客发现盘子都是空的，就等待
                wait(); // 缓冲区为空，等待生产者生产
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int num = buffer.remove();
        System.out.println("消费者消费：" + num);
        //顾客吃掉一盘，就通知一下厨师
        notifyAll(); // 通知生产者可以生产

        return num;
    }
}

// 生产者类  厨师
class Producer implements Runnable {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        //厨师目标 总共做10个菜，但是只有5个盘子
        for (int i = 1; i <= 10; i++) {
            buffer.produce(i);
        }
    }
}

// 消费者类  顾客
class Consumer implements Runnable {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            buffer.consume();
        }
    }
}
