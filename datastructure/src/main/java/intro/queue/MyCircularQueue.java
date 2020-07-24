package intro.queue;

import java.util.Arrays;

/**
 *
 * 此为自己的实现方式，需要多浪费一个元素位置，以便用 tail+1)%(size+1)==head 条件判断满
 */
public class MyCircularQueue {
    private int[] data;
    private int head;
    private int tail;
    private int size;

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3);
        System.out.println(circularQueue.enQueue(1));  // 返回 true
        System.out.println(circularQueue.enQueue(2));  // 返回 true
        System.out.println(circularQueue.enQueue(3));  // 返回 true
        System.out.println(circularQueue.enQueue(4));  // 返回 false，队列已满
        System.out.println(circularQueue.Rear());  // 返回 3
        System.out.println(circularQueue.isFull());  // 返回 true
        System.out.println(circularQueue.deQueue());  // 返回 true
        System.out.println(circularQueue.enQueue(4));  // 返回 true
        System.out.println(circularQueue.Rear());  // 返回 4
    }

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        data=new int[k+1];
        head=0;
        tail=0;
        size=k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()){
            return false;
        }
        data[tail] = value;
        tail = (tail+1)%(size+1);
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()){
            return false;
        }
        head = (head+1)%(size+1);
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()){
            return -1;
        }
        return data[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()){
            return -1;
        }
        return data[(tail+size)%(size+1)];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head == tail;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (tail+1)%(size+1)==head;
    }
}
