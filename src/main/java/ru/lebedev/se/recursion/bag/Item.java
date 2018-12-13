package ru.lebedev.se.recursion.bag;

public class Item {
    private String name; // Название предмета
    private int weight; // Вес
    private int coast; // Стоимость

    public Item(String name, int weight, int coast) {
        this.name = name;
        this.weight = weight;
        this.coast = coast;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCoast() {
        return coast;
    }

    public void setCoast(int coast) {
        this.coast = coast;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
