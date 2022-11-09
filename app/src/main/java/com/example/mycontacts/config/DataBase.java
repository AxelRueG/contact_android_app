package com.example.mycontacts.config;

import android.app.Application;

import androidx.room.Room;

import com.example.mycontacts.room.AppDatabase;

public class DataBase extends Application {
    public static AppDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(
                this,
                AppDatabase.class,
                "contacts_db"
        ).allowMainThreadQueries().build();
    }

}
