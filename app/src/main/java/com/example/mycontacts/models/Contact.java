package com.example.mycontacts.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contacts")
public class Contact {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public String number;
    public String email;
    public boolean favorite;
    public String photo;

    public Contact(String name, String number, String email, boolean favorite) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.favorite = favorite;
    }
}
