package Serg;

import javax.sound.midi.Soundbank;

public class NumberExeption extends Throwable
{
    String  ds="Ese";

    public NumberExeption(String s) {
        System.out.println("NEt Pravilniy VVod  " + s);
    }
}
