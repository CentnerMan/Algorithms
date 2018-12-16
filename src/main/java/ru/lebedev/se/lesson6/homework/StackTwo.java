package ru.lebedev.se.lesson6.homework;

public class StackTwo {
    private int maxSize;
    private NodeTwo[] stack;
    private int top;

    public StackTwo(int size) {
        this.maxSize = size;
        this.stack = new NodeTwo[this.maxSize];
        this.top = -1;
    }

    public void push(NodeTwo n) {
        this.stack[++this.top] = n;
    }

    public NodeTwo pop() {
        return this.stack[this.top--];
    }

    public NodeTwo peek() {
        return this.stack[this.top];
    }

    public boolean isEmpty() {
        return (this.top == -1);
    }

    public boolean isFull() {
        return (this.top == this.maxSize - 1);
    }

}
