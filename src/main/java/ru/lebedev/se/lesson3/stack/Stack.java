package ru.lebedev.se.lesson3;

public class Stack {
    private int maxSize;
    private int[] stack;
    private int top;

    public Stack(int size) {
        maxSize = size;
        stack = new int[maxSize];
        top = -1;
    }

    public void push(int i) {
        stack[++top] = i;
    }

    public int pop() {
        return stack[top--];
    }

    public int peek() {
        return stack[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

}
