package com.example.mycontacts.models;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.mycontacts.models.Contact;
import com.example.mycontacts.models.ContactDao;

@Database(entities = {Contact.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ContactDao contactDao();

//    private static final String DB_NAME = "contacts_db";
//    private static volatile AppDatabase instance;
//
//    public static synchronized AppDatabase getInstance(Context context) {
//        if (instance == null) {
//            instance = create(context);
//        }
//        return instance;
//    }
//
//    private static AppDatabase create(final Context context) {
//        return Room.databaseBuilder(
//                context,
//                AppDatabase.class,
//                DB_NAME).allowMainThreadQueries().build();
//    }
}
