package ru.lebedev.se.recursion.backpack;

import java.util.ArrayList;

public class ApplicationBackpack {
    static ArrayList<Item> items = new ArrayList<>();

    public static void main(String[] args) {

        items.add(new Item("Книга", 1, 600));
        items.add(new Item("Бинокль", 2, 5000));
        items.add(new Item("Аптечка", 4, 1500));
        items.add(new Item("Ноутбук", 2, 40000));
        items.add(new Item("Котелок", 1, 500));

        Backpack bp = new Backpack(8);

        ShowItems(items);
        ArrayList<Item> solve = bp.GetBestSet();

        if (solve == null) {
            System.out.println("Нет решения!");
        } else {
            ShowItems(solve);
        }
    }

    private static void ShowItems(ArrayList<Item> items) {
        for (int i = 0; i < ApplicationBackpack.items.size(); i++) {
            System.out.println("Название: " + ApplicationBackpack.items.get(i).name + ", вес: "
                    + ApplicationBackpack.items.get(i).weigth + ", стоимость: " + ApplicationBackpack.items.get(i).price);
        }
    }
}