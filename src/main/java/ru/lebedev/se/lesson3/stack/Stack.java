package ru.lebedev.se.lesson3.stack;

public class Stack {
//    private int maxSize;
//    private int[] stack;
//    private int top;
//
//    public Stack(int size) {
//        this.maxSize = size;
//        this.stack = new int[maxSize];
//        this.top = -1;
//    }
//
//    public void push(int i) {
//        stack[++top] = i;
//    }
//
//    public int pop() {
//        return stack[top--];
//    }
//
//    public int peek() {
//        return stack[top];
//    }
//
//    public boolean isEmpty() {
//        return (top == -1);
//    }
//
//    public boolean isFull() {
//        return (top == maxSize - 1);
//    }

    private int maxSize;
    private char[] stackArr;
    private int top;

    public Stack(int size){
        this.maxSize = size;
        this.stackArr = new char[size];
        this.top = -1;
    }

    public void push(char i){
        stackArr[++top] = i;
    }

    public char pop(){
        return stackArr[top--];
    }

    public boolean isEmpty(){
        return (top == -1);
    }

}
