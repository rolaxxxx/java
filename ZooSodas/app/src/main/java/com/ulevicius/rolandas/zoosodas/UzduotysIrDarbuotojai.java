package com.ulevicius.rolandas.zoosodas;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UzduotysIrDarbuotojai {

    @Query("SELECT * FROM UzduotysIrDarbininkai WHERE DarbuotojoIndexas IN (:DarbuotojaiIds)")
    List<String> DarbuotojoUzduotys(int[] DarbuotojaiIds);




}
