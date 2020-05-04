package Serg;

import java.util.Arrays;
import java.util.List;

import static java.lang.Math.abs;

public class InputRim
{
    public InputRim(String sp)
    {                                                                       // String rimskie ="X /VII";// System.out.println(rimskie);
        List<String> arrayList =Arrays.asList("I","II","III","IV","V","VI","VII","VIII","IX","X");// String sp = rimskie.replaceAll(" ","");
        String split[] = sp.split("[-+*/]");
        String a = split[0];String b = split[1];

            if (sp.contains("-"))
            {
                int sub = (arrayList.indexOf(a)+1)-(arrayList.indexOf(b)+1);
                if (sub<0)
                {
                    System.out.println("-"+arrayList.get(abs(sub+1))+"  Sub "+sub);
                }
                if(sub == 0)
                {
                    System.out.println("ZERO");
                }
                if (sub>0)
                {
                    System.out.println(arrayList.get(sub-1));
                }
            }
            if (sp.contains("+"))
            {
                int add = (arrayList.indexOf(a)+1)+(arrayList.indexOf(b)+1);
                if (add<11) { System.out.println(arrayList.get(add-1)); }
                if (add>10 && add<20)
                {
                    String adds = String.valueOf(add);
                    String sdf[] = adds.split("");//int a1 = Integer.parseInt(sdf[0]);
                    int b2 = Integer.parseInt(sdf[1]);
                    System.out.println(arrayList.get(9)+arrayList.get(b2-1));
                }
                if (add==20)   { System.out.println("XX"); }
            }
            if (sp.contains("*"))
            {
                int mult = (arrayList.indexOf(a)+1)*(arrayList.indexOf(b)+1);
                String multp = String.valueOf(mult);
                String sdf[] = multp.split("");
                if (mult%10==0)
                {
                    if (mult==10) System.out.println("X");
                    if (mult==20) System.out.println("XX");
                    if (mult==30) System.out.println("XXX");
                    if (mult==40) System.out.println("XL");
                    if (mult==50) System.out.println("L");
                    if (mult==60) System.out.println("LX");
                    if (mult==70) System.out.println("LXX");
                    if (mult==80) System.out.println("LXXX");
                    if (mult==90) System.out.println("XC");
                    if (mult==100) System.out.println("C"); //break;
                }

                int a1 = Integer.parseInt(sdf[0]);
                int b2 = Integer.parseInt(sdf[1]);
                if (a1==1 && b2!=0) System.out.println(arrayList.get(9)+arrayList.get(b2-1));
                if (a1==2 && b2!=0) System.out.println(arrayList.get(9)+arrayList.get(9)+arrayList.get(b2-1));
                if (a1==3 && b2!=0) System.out.println(arrayList.get(9)+arrayList.get(9)+arrayList.get(9)+arrayList.get(b2-1));
                if (a1==4 && b2!=0) System.out.println("XL"+arrayList.get(b2-1));
                if (a1==5 && b2!=0) System.out.println("L"+arrayList.get(b2-1));
                if (a1==6 && b2!=0) System.out.println("LX"+arrayList.get(b2-1));
                if (a1==7 && b2!=0) System.out.println("LXX"+arrayList.get(b2-1));
                if (a1==8 && b2!=0) System.out.println("LXXX"+arrayList.get(b2-1));
                if (a1==9 && b2!=0) System.out.println("LC"+arrayList.get(b2-1));

               // System.out.println("MulTiplication = : "+mult);
            }

            if (sp.contains("/"))
            {

                double div = (double) (arrayList.indexOf(a)+1)/(double) (arrayList.indexOf(b)+1);
                String s = String.valueOf(div);
                System.out.println(s);
                int i = (int)(Math.round(abs(div)));
                if (i==0)
                {
                    System.out.println("ZERO");
                }
                else System.out.println(arrayList.get(i-1));
            }

    }
}
