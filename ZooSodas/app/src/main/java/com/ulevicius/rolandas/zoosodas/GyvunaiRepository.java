package com.ulevicius.rolandas.zoosodas;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GyvunaiRepository {
    private String DB_NAME = "gyvunas";
    private AppDatabase gyvunai;
    public GyvunaiRepository(Context context) {
        gyvunai = Room.databaseBuilder(context, AppDatabase.class, DB_NAME).build();
    }
    public void  insertGyvunas(Gyvunas gyvunas) {
        insertGyvunasRep(gyvunas);
    }
    public void  deleteAll() {
        deleteGyvunai();
    }
    public   void getGyvunai(ArrayList<Gyvunas> gyvunaiDarbuotojuKlasei) {
        getGyvunaiFromDb( gyvunaiDarbuotojuKlasei);
        //return gyvunai.gyvunasDao().getGyvunai();
    }
    public void deleteOne(int index){
        removeOneAsync(index);
    }
    public void ShowGyvunai(ArrayList<String> gyvunai) {
        setGyvunai(gyvunai);
        //return gyvunai.gyvunasDao().getAll();
    }
    public void getGyvunaiFromDb(final ArrayList<Gyvunas> gyvunaiDarbuotojuKlasei) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
            gyvunaiDarbuotojuKlasei.addAll(gyvunai.gyvunasDao().getGyvunai());
            return null;
            }
        }.execute();
    }
    public void removeOneAsync(final int index) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                gyvunai.gyvunasDao().deleteOne(gyvunai.gyvunasDao().getGyvunai().get(index));
                return null;
            }
        }.execute();
    }
    public void deleteItems(final ArrayList<Gyvunas> gyvuniukai) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                gyvuniukai.removeAll( gyvunai.gyvunasDao().getGyvunai());
                return null;
            }
        }.execute();
    }
    public void setGyvunai(final ArrayList<String> gyvuniukai) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                gyvuniukai.addAll( gyvunai.gyvunasDao().Kategorija());
                return null;
            }
        }.execute();
    }
    public void insertGyvunasRep(final Gyvunas gyvunas) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                gyvunai.gyvunasDao().insertGyvunas(gyvunas);
                return null;
            }
        }.execute();
    }
    public void deleteGyvunai() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                gyvunai.gyvunasDao().deleteAll();
                return null;
            }
        }.execute();
    }
        }
