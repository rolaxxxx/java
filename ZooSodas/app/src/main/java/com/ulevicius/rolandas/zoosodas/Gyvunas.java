package com.ulevicius.rolandas.zoosodas;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Gyvunas implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "kategorija")
    String kategorija;

    @ColumnInfo(name = "rusis")
    String rusis;

    public String toString() {
        return String.format("  %s  %s  " , kategorija, rusis);
    }
}
