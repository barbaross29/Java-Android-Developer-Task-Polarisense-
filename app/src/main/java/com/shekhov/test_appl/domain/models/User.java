package com.shekhov.test_appl.domain.models;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "User")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id ;
    private String firstName ;
    private String lastName ;
    private boolean sex;

    public User()
    {}
    @Ignore
    public User(String firstName, String lastName, boolean sex)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
    }
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean getSex()
    {
        return sex;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSex(boolean sex)
    {
       this.sex = sex;
    }
}
