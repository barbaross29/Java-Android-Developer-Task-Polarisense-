package com.shekhov.test_appl.data.repository;

import com.shekhov.test_appl.data.RoomDatabase.AppLocalDatabase;
import com.shekhov.test_appl.domain.models.Quote;
import com.shekhov.test_appl.domain.repository.QuoteRepository;

import java.util.List;

public class QuoteRepositoryImpl implements QuoteRepository {

    private AppLocalDatabase appLocalDatabase;

    public QuoteRepositoryImpl(AppLocalDatabase appLocalDatabase)
    {
        this.appLocalDatabase = appLocalDatabase;
    }
    @Override
    public boolean saveQuotes(List<Quote> quotes) {
        if(this.appLocalDatabase.getQuotesDAO().insertQuotes(quotes).length > 0) return true;
        return false;
    }

    @Override
    public Quote getRandomQuote() {
        return this.appLocalDatabase.getQuotesDAO().getRandomQuote();
    }

    @Override
    public int getNumOfQuotes() {
        return this.appLocalDatabase.getQuotesDAO().getNumOfQuotes();
    }
}
