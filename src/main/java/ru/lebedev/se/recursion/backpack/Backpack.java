package ru.lebedev.se.recursion.backpack;

import java.util.ArrayList;

public class Backpack {
    private ArrayList<Item> bestItems = null;

    private double maxWeight;

    private double bestPrice;

    public Backpack(int maxWeight)
    {
        this.maxWeight = maxWeight;
    }


    //создание всех наборов перестановок значений
    public void MakeAllSets(ArrayList<Item> items)
    {
        if (items.size() > 0)
            CheckSet(items);

        for (int i = 0; i < items.size(); i++)
        {
            ArrayList<Item> newSet = new ArrayList<Item> (items);

            newSet.remove(i);

            MakeAllSets(newSet);
        }

    }

    //проверка, является ли данный набор лучшим решением задачи
    private void CheckSet(ArrayList<Item> items)
    {
        if (bestItems == null)
        {
            if (CalcWeigth(items) <= maxWeight)
            {
                bestItems = items;
                bestPrice = CalcPrice(items);
            }
        }
        else
        {
            if(CalcWeigth(items) <= maxWeight && CalcPrice(items) > bestPrice)
            {
                bestItems = items;
                bestPrice = CalcPrice(items);
            }
        }
    }

    //вычисляет общий вес набора предметов
    private double CalcWeigth(ArrayList<Item> items)
    {
        int sumW = 0;

        for (int i = 0; i < items.size(); i++) {
            sumW += items.get(i).weigth;
        }

        return sumW;
    }

    //вычисляет общую стоимость набора предметов
    private double CalcPrice(ArrayList<Item> items)
    {
        double sumPrice = 0;

        for (int i = 0; i < items.size(); i++)
        {
            sumPrice += items.get(i).price;
        }

        return sumPrice;
    }

    //возвращает решение задачи (набор предметов)
    public ArrayList<Item> GetBestSet()
    {
        return bestItems;
    }
}
