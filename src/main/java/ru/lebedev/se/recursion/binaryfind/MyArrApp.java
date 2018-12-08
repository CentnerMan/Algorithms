package ru.lebedev.se.recursion.binaryfind;

public class MyArrApp {
    public static void main(String[] args) {

        MyArr arr = new MyArr(10);
        arr.insert(-10);
        arr.insert(45);
        arr.insert(26);
        arr.insert(20);
        arr.insert(25);
        arr.insert(40);
        arr.insert(75);
        arr.insert(80);
        arr.insert(82);
        arr.insert(91);

        int search = 82;

        System.out.println(arr.binaryFind(search));
    }
}
