package Serg;

public class Kalculator
{
    public Kalculator(String s) {
        {
                String sp = s.replaceAll(" ", "");
                String mas[] = sp.split("[-+*/]");
                String a = mas[0];
                String b = mas[1];
                byte a1 = Byte.parseByte(a);
                byte b2 = Byte.parseByte(b);
                if (s.contains("-")) System.out.println((a1-b2));
                if (s.contains("+")) System.out.println((a1+b2));
                if (s.contains("*")) System.out.println((a1*b2));
                if (s.contains("/")) System.out.println((double) a1/(double) b2);
        }
    }
}
