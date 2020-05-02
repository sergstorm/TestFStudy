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
                System.out.println(s + " posle replecementa");
                String mas[] = s.split("[-+*\\/]");
                String a = mas[0];
                String b = mas[1];
                System.out.println(a + "  AiB  " + b);
                if (arrayList.contains(a) && arrayList.contains(b))
                {
                    System.out.println(" go to ROME");
                    new InputRim(s);  //poshli v klass s rimskimi
                }
                else if ((chek(a)&&chek(b)))
                {
                    System.out.println(" Go to ARABIYA");
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




//        new Kalculator();
//        String rimskie ="X /VII";
//        System.out.println(rimskie);
//       List<String> arrayList =Arrays.asList("I","II","III","IV","V","VI","VII","VIII","IX","X");
//       String sp = rimskie.replaceAll(" ","");
//       String split[] = sp.split("[-+*/]");
//       String a = split[0];String b = split[1];
//        System.out.println(a+" 1slag i vtoroe "+a);
//        if (arrayList.contains(a) &&arrayList.contains(b))
//        {
//            System.out.println("ok");
//            System.out.println(arrayList.indexOf(a)+1);
//            System.out.println(arrayList.indexOf(b)+1);
//
//            if (sp.contains("-"))
//            {
//                int sub = (arrayList.indexOf(a)+1)-(arrayList.indexOf(b)+1);
//                if (sub<0)
//                {
//                    System.out.println("-"+arrayList.get(Math.abs(sub+1))+"  Sub "+sub);
//                }
//                if(sub ==0)
//                {
//                    System.out.println("ZERO");
//                }
//                if (sub>0)
//                    {
//                        System.out.println(arrayList.get(sub-1)+"  Sub "+sub);
//                    }
//                }
//            if (sp.contains("+"))
//            {
//                int add = (arrayList.indexOf(a)+1)+(arrayList.indexOf(b)+1);
//                  if (add<11)
//                       {
//                           System.out.println(arrayList.get(add-1));
//                       }
//                       if (add>10 && add<20)
//                          {
//                             String adds = String.valueOf(add);
//                             String sdf[] = adds.split("");
//
//                             int a1 = Integer.parseInt(sdf[0]);
//                             int b2 = Integer.parseInt(sdf[1]);
//                              System.out.println("MEjor 10 "+arrayList.get(9)+arrayList.get(b2-1));
//                          }
//                          if (add==20)
//                          {
//                              System.out.println("XX");
//                          }
//
//          }
//            if (sp.contains("*"))
//            {
//                int mult = (arrayList.indexOf(a)+1)*(arrayList.indexOf(b)+1);
//                String multp = String.valueOf(mult);
//                String sdf[] = multp.split("");
//                if (mult%10==0)
//                {
//                  if (mult==10) System.out.println("Desiatok=X");
//                  if (mult==20) System.out.println("Desiatok=XX");
//                  if (mult==30) System.out.println("Desiatok=XXX");
//                  if (mult==40) System.out.println("Desiatok=XL");
//                  if (mult==50) System.out.println("Desiatok=L");
//                  if (mult==60) System.out.println("Desiatok=LX");
//                  if (mult==70) System.out.println("Desiatok=LXX");
//                  if (mult==80) System.out.println("Desiatok=LXXX");
//                  if (mult==90) System.out.println("Desiatok=XC");
//                  if (mult==100) System.out.println("Desiatok=C"); //break;
//                 }
//
//                int a1 = Integer.parseInt(sdf[0]);
//                int b2 = Integer.parseInt(sdf[1]);
//                if (a1==1) System.out.println("MEjor 10 "+arrayList.get(9)+arrayList.get(b2-1));
//                if (a1==2) System.out.println("MEjor 20 "+arrayList.get(9)+arrayList.get(9)+arrayList.get(b2-1));
//                if (a1==3) System.out.println("MEjor 30 "+arrayList.get(9)+arrayList.get(9)+arrayList.get(9)+arrayList.get(b2-1));
//                if (a1==4) System.out.println("MEjor 40 "+"XL"+arrayList.get(b2-1));
//                if (a1==5) System.out.println("MEjor 50 "+"L"+arrayList.get(b2-1));
//                if (a1==6) System.out.println("MEjor 60 "+"LX"+arrayList.get(b2-1));
//                if (a1==7) System.out.println("MEjor 70 "+"LXX"+arrayList.get(b2-1));
//                if (a1==8) System.out.println("MEjor 80 "+"LXXX"+arrayList.get(b2-1));
//                if (a1==9) System.out.println("MEjor 90 "+"LC"+arrayList.get(b2-1));
//
//                System.out.println("MulTiplication = : "+mult);
//            }
//
//            if (sp.contains("/"))
//            {
//
//                double div = (double) (arrayList.indexOf(a)+1)/(double) (arrayList.indexOf(b)+1);
//                String s = String.valueOf(div);
//                System.out.println("a1/b2="+div+"Str "+s+arrayList.get((int) (Math.abs(div))-1));
//            }
//        }

