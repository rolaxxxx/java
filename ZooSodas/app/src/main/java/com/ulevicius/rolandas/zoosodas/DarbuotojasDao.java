package com.ulevicius.rolandas.zoosodas;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface DarbuotojasDao {
    @Query("SELECT * FROM darbuotojas")
    List<Darbuotojas> getDarbuotojai();

    @Insert
    void insertDarbuotojas(Darbuotojas darbuotojas);

    @Delete
    void deleteDarbuotojas(Darbuotojas... darbuotojas);

    @Query("DELETE FROM darbuotojas")
    void deleteAllDarbuotojai();


}
