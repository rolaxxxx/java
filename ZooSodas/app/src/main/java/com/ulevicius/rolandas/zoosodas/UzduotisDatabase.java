package com.ulevicius.rolandas.zoosodas;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Uzduotis.class}, version = 1)
public  abstract  class UzduotisDatabase extends RoomDatabase {
    public abstract UzduotisDao uzduotisDao();
}
