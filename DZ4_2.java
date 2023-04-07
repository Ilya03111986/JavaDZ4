package DZ4;
/*
 * Task_4

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Task_4 {

//Даны два Deque представляющие два неотрицательных целых числа. Цифры хранятся в обратном порядке,
// и каждый из их узлов содержит одну цифру.
// Сложите два числа и верните сумму в виде связанного списка.
public static void main(String[] args) {
    Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(1,2,3));
    Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(5,4,7));
    // result [6,6,0,1]

}


public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) {

    return new ArrayDeque<>();
}
}
 */

 import java.util.ArrayDeque;
 import java.util.Deque;
 import java.util.Scanner;

 public class DZ4_2 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите первое число: ");
            String s1 = scanner.nextLine();
            System.out.print("Введите второе число: ");
            String s2 = scanner.nextLine();
            Deque<Integer> d1 = parseNumber(s1);
            Deque<Integer> d2 = parseNumber(s2);
            Deque<Integer> result = sum(d1, d2);
            System.out.println("Результат сложения Deque: " + result); // Результат сложения Deque
        }
    }

    public static Deque<Integer> parseNumber(String s) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                deque.addFirst(c - '0');
            } else {
                throw new IllegalArgumentException("Некорректный ввод числа: " + s);
            }
        }
        return deque;
    }

    public static Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) {
        Deque<Integer> result = new ArrayDeque<>();
        int carry = 0; // остаток от предыдущего разряда
        while (!d1.isEmpty() || !d2.isEmpty()) { // пока есть цифры в обоих Deque-ах
            int x = d1.isEmpty() ? 0 : d1.removeFirst(); // если в d1 закончились цифры, заменяем их нулями
            int y = d2.isEmpty() ? 0 : d2.removeFirst(); // если в d2 закончились цифры, заменяем их нулями
            int sum = x + y + carry; // суммируем соответствующие цифры и остаток от предыдущего разряда
            result.addLast(sum % 10); // добавляем остаток от деления суммы на 10
            carry = sum / 10; // вычисляем новый остаток от предыдущего разряда
        }
        if (carry > 0) { // если в конце остался остаток от предыдущего разряда, добавляем его в результат
            result.addLast(carry);
        }
        return result;
    }
}
