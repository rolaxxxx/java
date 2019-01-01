package com.ulevicius.rolandas.zoosodas;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.Collection;
import java.util.List;

@Dao
public interface GyvunasDao {
    @Query("SELECT kategorija FROM gyvunas")
    List<String> Kategorija();

    @Query("SELECT * FROM gyvunas")
     List<Gyvunas> getGyvunai();

    @Query("SELECT * FROM gyvunas WHERE uid IN (:gyvunaiIds)")
    List<Gyvunas> loadAllByIds(int[] gyvunaiIds);

    @Insert
    void insertGyvunas(Gyvunas gyvunas);

    @Delete
     void deleteOne(Gyvunas... gyvunai);

    @Query("DELETE FROM gyvunas")
     void deleteAll();
}