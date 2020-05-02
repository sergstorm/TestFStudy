package Serg;

public class Kalculator
{
    public Kalculator(String s) throws NumberExeption {
        {
                String sp = s.replaceAll(" ", "");
                System.out.println(s + " posle replecementa");
                String mas[] = sp.split("[-+*/]");
                String a = mas[0];
                String b = mas[1];
                System.out.println(a+"A i  B"+b+"");
                byte a1 = Byte.parseByte(a);
                byte b2 = Byte.parseByte(b);
                if (s.contains("-")) System.out.println("a1-b2="+(a1-b2));
                if (s.contains("+")) System.out.println("a1+b2="+(a1+b2));
                if (s.contains("*")) System.out.println("a1*b2="+(a1*b2));
                if (s.contains("/")) System.out.println("a1/b2="+(double) a1/(double) b2);
        }
    }
}
