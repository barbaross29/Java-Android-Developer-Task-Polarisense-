package com.shekhov.test_appl.data.RoomDatabase.DAOS;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import com.shekhov.test_appl.domain.models.Quote;

import java.util.List;

@Dao
public interface QuotesDAO {

    @Insert
    long[] insertQuotes(List<Quote> quotes);

    @Query("SELECT * FROM Quotes ORDER BY RANDOM() LIMIT 1")
    Quote getRandomQuote();

    @Query("SELECT COUNT(*) FROM Quotes")
    int getNumOfQuotes();
}
