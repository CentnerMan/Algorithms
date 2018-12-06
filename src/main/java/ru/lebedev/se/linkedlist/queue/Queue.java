package ru.lebedev.se.linkedlist.queue;

import ru.lebedev.se.linkedlist.twoside.Link;
import ru.lebedev.se.linkedlist.twoside.LinkedList;

public class Queue {
    private LinkedList queue;

    public Queue() {
        queue = new LinkedList();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void insert(String name, int age) {
        queue.insertFirst(name, age);
    }

    public Link delete() {
        return queue.delete();
    }

    public void display() {
        queue.display();
    }

}
