package DZ4;
/*
 * Task_5
import java.util.Deque;

public class Task_5 {

//Дана строка содержащая только символы '(', ')', '{', '}', '[' и ']', определите,
// является ли входная строка логически правильной.
// Входная строка логически правильная, если:
// 1) Открытые скобки должны быть закрыты скобками того же типа.
// 2) Открытые скобки должны быть закрыты в правильном порядке. Каждая закрывающая скобка имеет соответствующую
// открытую скобку того же типа.
// ()[] = true
// () = true
// {[()]} = true
// ()() = true
// )()( = false

public static void main(String[] args) {

}

public boolean validate(Deque<Integer> deque){

    return false;
}
}
 */
import java.util.Scanner;
import java.util.Stack;

 public class DZ4_3 {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите строку, содержащую только символы '(', ')', '{', '}', '[' и ']': ");
            String inputString = scanner.nextLine();

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < inputString.length(); i++) {
                char c = inputString.charAt(i);

                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    System.out.println("Введенная строка логически неправильная");
                    return;
                }
            }

            if (stack.isEmpty()) {
                System.out.println("Введенная строка логически правильная");
            } else {
                System.out.println("Введенная строка логически неправильная");
            }
        }
    }
}
