package com.ulevicius.rolandas.zoosodas;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

    @Entity
public class Uzduotis {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "uzduotis")
    String tekstas;

    @ColumnInfo(name = "priskirtasDarbuotojas")
    String priskirtasDarbuotojas;

    @ColumnInfo(name = "priziurimasGyvunas")
    String specifinisGyvunas;
}
