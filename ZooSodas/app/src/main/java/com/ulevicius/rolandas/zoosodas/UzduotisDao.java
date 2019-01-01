package com.ulevicius.rolandas.zoosodas;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UzduotisDao {
    @Query("DELETE FROM uzduotis")
    void deleteAlluzduotys();

    @Query("SELECT * FROM uzduotis")
    List<Uzduotis> getUzduotis();

    @Insert
    void insertUzduotis(Uzduotis uzduotis);

    @Delete
    void deleteUzduotis(Uzduotis... uzduotis);



}
