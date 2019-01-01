package com.ulevicius.rolandas.zoosodas;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class UzduotysIrDarbininkai {
    @PrimaryKey(autoGenerate = true)
    public int uid;

        @ColumnInfo(name = "DarbuotojoIndexas")
   public int DI;

    @ColumnInfo(name = "UzduotiesIndexas")
   public int UI;




}
