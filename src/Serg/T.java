package Serg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author Sumin Sergey
 * date 1.05.2020
 * Создайте консольное приложение “Калькулятор”.
 * Приложение должно читать из консоли введенные пользователем арифметические операции и выводить в консоль результат их выполнения.
 *
 * Требования:
 * Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами: a + b, a - b, a * b, a / b. Данные передаются в одну строку (смотрите пример)! Решения, в которых каждое число и арифмитеческая операция передаются с новой строки считаются неверными.
 * Калькулятор умеет работать как с арабскими (1,2,3,4,5…), так и с римскими (I,II,III,IV,V…) числа.
 * Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более. На выходе числа не ограничиваются по величине и могут быть любыми.
 * Калькулятор умеет работать только с целыми числами.
 * Калькулятор умеет работать только с арабскими или римскими цифрами одновременно, при вводе пользователем строки вроде 3 + II калькулятор должен выбросить исключение и прекратить свою работу.
 * При вводе пользователем неподходящих чисел приложение выбрасывает исключение и завершает свою работу.
 * При вводе пользователем строки не соответствующей одной из вышеописанных арифметических операций приложение выбрасывает исключение и завершает свою работу.
 *
*/

public class T {
    public static void main(String[] args) throws IOException, NumberExeption {
        String s = "";
        List<String> arrayList = Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true)
            {
                s = reader.readLine().trim().replaceAll(" ", "");// May bi\\s
                if (s.length() < 3)
                {
                    throw new NumberExeption(s);
                }
                if (!s.contains("+") && !s.contains("-") && !s.contains("*") && !s.contains("/"))
                {
                    throw new NumberExeption(s);
                }

                String mas[] = s.split("[-+*\\/]");
                String a = mas[0];
                String b = mas[1];

                if (arrayList.contains(a) && arrayList.contains(b))
                {
                   // System.out.println(" go to ROME");
                    new InputRim(s);  //poshli v klass s rimskimi
                }
                else if ((chek(a)&&chek(b)))
                {
                   // System.out.println(" Go to ARABIYA");
                    new Kalculator(s);
                }
                else throw new NumberExeption(s);

            }
        }
    }
    private static boolean chek(String s) {
        if (s.matches("^(\\d{1}|10)")) return true;
        else return false;
    }
}


