package ru.lebedev.se.lesson3.queue;

public class JavaQueue {
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.insert(10);
        q.insert(20);
        q.insert(30);
        q.insert(40);

        q.remove();
        q.remove();
        q.remove();

        q.insert(50);
        q.insert(60);
        q.insert(70);
        q.insert(80);

        while (!q.isEmpty()) {
            int n = q.remove();
            System.out.println(n);
        }
    }

}
