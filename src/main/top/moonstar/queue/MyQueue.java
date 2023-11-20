package top.moonstar.queue;

import java.util.Stack;

public class MyQueue {
    private final Stack<Integer> inStack = new Stack<>();
    private final Stack<Integer> outStack = new Stack<>();

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }

    public MyQueue() {
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.size() == 0) {
            shift();
        }

        return outStack.pop();
    }

    public int peek() {
        if (outStack.size() == 0) {
            shift();
        }

        return outStack.peek();
    }

    public boolean empty() {
        return (outStack.size() + inStack.size()) == 0;
    }

    private void shift() {
        while (inStack.size() > 0) {
            outStack.push(inStack.pop());
        }
    }
}
