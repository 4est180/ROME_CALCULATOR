import java.util.InputMismatchException;
import java.util.Scanner;


public class Calculator {
    static Scanner scanner = new Scanner(System.in);
    static int value1, value2;
    static char operation;
    static int answer;

    public static void main (String[] args) {
        System.out.println("Вас приветствует калькулятор арабских и римских чисел от 1 до 10");
        System.out.println("Введите выражение для вычислений из двух чисел без пробелов");

        String userInput = scanner.nextLine();

        char[] input_line_char = new char[10];

        for (int i = 0; i < userInput.length(); i++) {
            input_line_char[i] = userInput.charAt(i);
            if (input_line_char[i] == '+') {
                operation = '+';
            }
            if (input_line_char[i] == '-') {
                operation = '-';
            }
            if (input_line_char[i] == '*') {
                operation = '*';
            }
            if (input_line_char[i] == '/') {
                operation = '/';
            }
        }
        String input_line_charString = String.valueOf(input_line_char);
        String[] numbers = input_line_charString.split("[+-/*]");
        String const00 = numbers[0];
        String const01 = numbers[1];
        String const03 = const01.trim();
        value1 = romanToArabian(const00);
        value2 = romanToArabian(const03);
        if (value1 < 0 && value2 < 0) {
            answer = 0;
        } else {
            answer = calculated(value1, value2, operation);
            System.out.println("----Ответ для римских чисел----");
            String answerRoman = convertNumToRoman(answer);
            System.out.println(answerRoman);
        }
        value1 = Integer.parseInt(const00);
        value2 = Integer.parseInt(const03);
        answer = calculated(value1, value2, operation);
        System.out.println("----Ответ для арабских чисел----");
        System.out.println(answer);
    }

    private static String convertNumToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[numArabian];
        return s;
    }


    private static int romanToArabian (String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Некорректный ввод");
        }
        return -1;
    }

    public static int calculated (int num1, int num2, char op) {
        int answer = 0;
        switch (op) {
            case '+':
                answer = num1 + num2;
                break;
            case '-':
                answer = num1 - num2;
                break;
            case '*':
                answer = num1 * num2;
                break;
            case '/':
                try {
                    answer = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Некорректный ввод : " + e);
                    System.out.println("Принимаются только целые числа");

                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Введите +, -, * или /");
        }
        return answer;
    }
}
