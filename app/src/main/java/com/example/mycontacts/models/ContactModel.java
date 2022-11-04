package com.example.mycontacts.models;

public class ContactModel {
    public int id;
    public String name;
    public String number;
    public String photo;

    public ContactModel(int id, String name, String number, String photo) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.photo = photo;
    }
}
