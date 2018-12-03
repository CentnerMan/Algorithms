package ru.lebedev.se.lesson3.deque;

public class JavaDeque {
    public static void main(String[] args) {
        Deque dq = new Deque(5);
        dq.insertLast('h');
        dq.insertFirst('z');
        dq.insertFirst('y');
        dq.removeFirst();
        dq.insertFirst('m');
        dq.insertLast('f');

        while (!dq.isEmpty()) {
            char n = dq.removeFirst();
            System.out.println(n);
        }
    }
}
