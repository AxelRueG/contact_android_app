package com.example.mycontacts.models;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface ContactDao {
    @Query("SELECT * FROM contacts")
    List<Contact> getAll();

    @Insert
    void insert(Contact... contacts);

    @Delete
    void delete(Contact contact);
}
