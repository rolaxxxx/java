package com.ulevicius.rolandas.zoosodas;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Darbuotojas.class}, version = 1)
public abstract class DarbuotojasDatabase extends RoomDatabase {
    public abstract DarbuotojasDao darbuotojasDao();
}
