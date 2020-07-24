package intro.queue;

import java.math.BigDecimal;

public class MovingAverage {

    private MyCircularQueue queue;

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        m.next(1);//1
        m.next(10);// (1 + 10) / 2
        m.next(3) ;// (1 + 10 + 3) / 3
        m.next(5) ;// (10 + 3 + 5) / 3
    }

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new MyCircularQueue(size);
    }

    public double next(int val) {
        if (queue.isFull()){
            queue.deQueue();
        }
        queue.enQueue(val);
        double avg = queue.avg();
        System.out.println(avg);
        return avg;
    }

    public static class MyCircularQueue{
        private int[] data;
        private int head;
        private int tail;
        private int size;

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

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return head == tail;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return (tail+1)%(size+1)==head;
        }

        public double avg() {
            double  total = 0;
            double  length = 0;
            for (int i = head;  ; i = (i+1)%(size+1)) {
                if (i == tail){
                    break;
                }
                length ++;
                total += data[i];
            }

            return total/length;
        }
    }
}
