package ru.lebedev.se.recursion.bag;

//2.	Написать программу «Задача о рюкзаке» с помощью рекурсии.

public class BagApp {

    static Bag bag = new Bag(15);
    static Bag bestBag = bag;
    static int poolItems = 6; // количество исходных предметов

    public static void main(String[] args) {

        // Определяем запас предметов для наполнения рюкзака
        Item[] items = new Item[poolItems];

        items[0] = new Item("Ноутбук", 2, 30000);
        items[1] = new Item("Хлеб", 1, 100);
        items[2] = new Item("Картофель", 10, 1000);
        items[3] = new Item("Мясо", 5, 2000);
        items[4] = new Item("Куртка", 4, 8000);
        items[5] = new Item("Кастрюля", 3, 500);

        pullBag(0, bag, items); // i - начальное значение для перебора
        bestBag.display();
    }


    private static void pullBag(int i, Bag bag, Item[] items) {

        if (i >= poolItems) return; // Вне диапазона

        for (int j = i; j < poolItems; j++) { // идем по всем предметам

            if (bag.getMaxWeight() >= bag.getCurrentWeight() + items[j].getWeight()) { // Влезает?
                bag.add(items[j]); // Запихиваем
//                bag.display();
                if (bag.getCoastItems() > bestBag.getCoastItems()) bestBag = bag; // Если оптимальнее - в лучший рюкзак;
            }
            pullBag(j + 1, bag, items);
            rotate(items, poolItems - 1);
        }


    }

    public static void rotate(Item[] items, int newSize) {
        int i;
        int position = items.length - newSize;
        Item temp = items[position];
        for (i = position + 1; i < items.length; i++) {
            items[i - 1] = items[i];
        }
        items[i - 1] = temp;
    }


}
