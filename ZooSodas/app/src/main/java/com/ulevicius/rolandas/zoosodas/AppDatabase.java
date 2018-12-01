package com.ulevicius.rolandas.zoosodas;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.ulevicius.rolandas.zoosodas.GyvunasDao;
import com.ulevicius.rolandas.zoosodas.GyvunuValdymas;

@Database(entities = {Gyvunas.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract GyvunasDao gyvunasDao();

}