package com.ulevicius.rolandas.zoosodas;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {UzduotysIrDarbininkai.class}, version = 1)
public  abstract class DarbuotojaiIrUzduotysDatabase extends RoomDatabase
{
    public abstract UzduotysIrDarbuotojai uzduotysIrDarbuotojai();
}
