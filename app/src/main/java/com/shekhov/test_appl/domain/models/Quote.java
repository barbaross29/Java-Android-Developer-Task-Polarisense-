package com.shekhov.test_appl.domain.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Quotes")
public class Quote {
    @PrimaryKey(autoGenerate = true)
    private int id ;
    private String quote;
    private String author;

    public Quote(String quote, String author)
    {
        this.quote = quote;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getQuote() {
        return quote;
    }

    public String getAuthor()
    {return author;}

    public void setId(int id) {
        this.id = id;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }
}
