package com.shekhov.test_appl.domain.repository;

import com.shekhov.test_appl.domain.models.Quote;

import java.util.List;

public interface QuoteRepository {

    boolean saveQuotes(List<Quote> quotes);
    Quote getRandomQuote();
    int getNumOfQuotes();
}
