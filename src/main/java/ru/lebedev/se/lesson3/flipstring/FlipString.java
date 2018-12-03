package ru.lebedev.se.lesson3.flipstring;

import ru.lebedev.se.lesson3.deque.Deque;
import java.util.Scanner;

public class FlipString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputStr = "", outputStr = "";
        Deque flip = new Deque(512); // Стек на базе дека

        System.out.println("Введите строку для разворота:");
        inputStr = sc.nextLine();

        // Заводим в стек посимвольно
        for (int i = 0; i < inputStr.length(); i++) {
//            flip.insertLast(inputStr.charAt(i));
            flip.insertFirst(inputStr.charAt(i));
        }

        // Выводим из стека посимвольно
        for (int i = 0; i < inputStr.length(); i++) {
//            outputStr = outputStr + flip.removeLast();
            outputStr = outputStr + flip.removeFirst();
        }
        System.out.println(outputStr);
        sc.close();
    }
}
