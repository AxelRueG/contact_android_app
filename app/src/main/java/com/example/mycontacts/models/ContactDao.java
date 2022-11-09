package com.example.mycontacts.models;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mycontacts.models.Contact;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface ContactDao {
    @Query("SELECT * FROM contacts")
    List<Contact> getAll();

    @Query("SELECT * FROM contacts WHERE id=:id")
    Contact getContact(int id);

    @Insert
    void insert(Contact... contacts);

    @Delete
    void delete(Contact contact);

    @Update
    void update(Contact contact);
}
