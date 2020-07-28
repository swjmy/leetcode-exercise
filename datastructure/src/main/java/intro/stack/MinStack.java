package intro.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * TODO 未完成。
 */
class MinStack {

    private Deque<Integer> eleStack = new ArrayDeque<>();
    private Deque<Integer> minStack = new ArrayDeque<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        eleStack.push(x);
        Integer peek = minStack.peek();
        if (peek != null && peek < x){
            minStack.push(peek);
        }else {
            minStack.push(x);
        }

    }

    public void pop() {
        minStack.pop();
        eleStack.pop();
    }

    public int top() {
        return eleStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */