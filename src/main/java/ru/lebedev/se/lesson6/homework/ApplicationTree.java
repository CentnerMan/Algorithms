package ru.lebedev.se.lesson6.homework;

/*

1. Создать и запустить программу для построения двоичного дерева. В цикле построить двадцать деревьев с глубиной в 6 уровней.
Данные, которыми необходимо заполнить узлы деревьев, представляются в виде чисел типа int.
Число, которое попадает в узел, должно генерироваться случайным образом в диапазоне от -100 до 100.

2. Проанализировать, какой процент созданных деревьев являются несбалансированными.

 */

public class ApplicationTree {

    public static void main(String[] args) {
        int ballancedTrees = 0;
        int numTrees = 20;
        for (int i = 0; i < numTrees; i++) {
            TreeInt tree = new TreeInt();
            tree.insert(0); // root по центру
            for (int j = 0; j < 8; j++) {
                int num = (int) (Math.random() * 200 - 100);
                tree.insert(num);
            }
//            tree.displayTree();
            if (tree.isBalanced(tree.getRoot())) {
//                System.out.println("Сбалансировано");
                ballancedTrees++;
            } //else System.out.println("Не сбалансировано");
        }
        System.out.println("Сбалансировано " + (ballancedTrees * 100 / numTrees) + "% деревьев");
        System.out.println("Несбалансировано " + (100-(ballancedTrees * 100 / numTrees)) + "% деревьев");
    }
}
