package DZ4;
/*
 * Task_3
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Task_3 {

// Дан Deque состоящий из последовательности цифр.
// Необходимо проверить, что последовательность цифр является палиндромом
public static void main(String[] args) {
    Deque<Integer> deque = new ArrayDeque<>(Arrays.asList(1,2,3,4,5,6));

}


public boolean checkOn(Deque<Integer> deque){

    return false;
}
}
 */
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DZ4_1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите последовательность цифр через пробел: ");
            String input = scanner.nextLine();

            String[] numbers = input.split(" ");
            Deque<Integer> deque = new ArrayDeque<>();
            for (String number : numbers) {
                deque.add(Integer.parseInt(number));
            }

            if (checkOn(deque)) {
                System.out.println("Последовательность является палиндромом");
            } else {
                System.out.println("Последовательность не является палиндромом");
            }
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Метод проверяет, является ли последовательность цифр в Deque палиндромом.
     *
     * @param deque Deque с последовательностью цифр
     * @return true, если последовательность является палиндромом, иначе - false
     */
    public static boolean checkOn(Deque<Integer> deque) {
        // Создаем копию Deque, т.к. будем извлекать элементы из начала и конца очереди и портить оригинальную
        Deque<Integer> copyDeque = new ArrayDeque<>(deque);

        // Пока в Deque остались элементы
        while (copyDeque.size() > 1) {
            // Извлекаем первый и последний элементы
            int first = copyDeque.pollFirst();
            int last = copyDeque.pollLast();

            // Если они не равны, то последовательность не является палиндромом
            if (first != last) {
                return false;
            }
        }

        // Если метод не вышел из цикла, значит последовательность является палиндромом
        return true;
    }
}
