package ru.lebedev.se.lesson3.deque;

public class Deque {
    private int maxSize;
    private char[] deque;
    private int front;
    private int rear;
    private int items;

    public Deque(int s) {
        maxSize = s;
        deque = new char[maxSize];
        front = 0;
        rear = -1;
        items = 0;
    }

    public void insertFirst(char ch) {
        if (front > 0) {
            front--;
            deque[front] = ch;
        }
        if (front == 0) {
            front = maxSize;
            deque[--front] = ch;
        }
        items++;
    }

    public void insertLast(char ch) {
        if (rear == maxSize - 1)
            rear = -1;
        deque[++rear] = ch;
        items++;
    }

    public char removeFirst() {
        char temp = deque[front++];
        if (front == maxSize)
            front = 0;
        items--;
        return temp;
    }

    public char removeLast() {
        char temp = deque[rear--];
        if (rear == maxSize - 1)
            rear = -1;
        items--;
        return temp;
    }

    public char peekFirst() {
        return deque[front];
    }

    public char peekLast() {
        return deque[rear];
    }

    public boolean isEmpty() {
        return (items == 0);
    }

    public boolean isFull() {
        return (items == maxSize);
    }

    public int size() {
        return items;
    }


}
