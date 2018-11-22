package com.ulevicius.rolandas.zoosodas;

import java.util.ArrayList;

public class Darbuotojas {
            String vardas;
            String pavarde;
            String priskirtaKategorija;
            ArrayList<String> priskirtosUzduotys;
    public String toString() {
        return String.format(" %s, %s, %s, %s " ,vardas, pavarde, priskirtaKategorija);
    }

}
