package com.ulevicius.rolandas.zoosodas;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
import java.util.ArrayList;
@Entity
public class Darbuotojas implements Serializable {
             @PrimaryKey(autoGenerate = true)
             public int uid;

             @ColumnInfo(name = "DarbuotojoVardas")
            String vardas;
             @ColumnInfo(name = "DarbuotojoPavarde")
            String pavarde;
             @ColumnInfo(name = "PriskirtaKategorija")
            String priskirtaKategorija;
             @ColumnInfo(name = "PriskirtosUzduotys")
            ArrayList<String> priskirtosUzduotys;

    public String toString() {
        return String.format(" %s  %s  %s " ,vardas, pavarde, priskirtaKategorija);
    }

}
