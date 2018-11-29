package ru.lebedev.se.lesson2;

public class PersonMain {

    public static void main(String[] args) {
        int size = 1000000;
        PersonArray arr = new PersonArray(size);
        arr.insert("Vasya", 10);
        arr.insert("Igor", 15);
        arr.insert("Quincy", 17);
        arr.insert("Semen", 14);
        arr.insert("Goga", 11);
        arr.insert("Xerox", 5);
        arr.insert("Alex", 6);
        arr.insert("Joshua", 12);

        arr.display();

//        arr.sortBubbleByName();
        arr.sortSelectByName();
//        arr.sortInsertPersonByName();

        System.out.println("--------------------");
        arr.display();

        arr.sortInsertPersonByAge();

        System.out.println("--------------------");
        arr.display();

    }
}
