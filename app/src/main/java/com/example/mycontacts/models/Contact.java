package com.example.mycontacts.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contacts")
public class Contact {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public String number;
    public String photo;

    public Contact(String name, String number, String photo) {
        this.name = name;
        this.number = number;
        this.photo = photo;
    }
}
