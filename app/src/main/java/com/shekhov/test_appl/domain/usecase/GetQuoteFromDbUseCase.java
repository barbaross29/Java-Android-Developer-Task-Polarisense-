package com.shekhov.test_appl.domain.usecase;

import com.shekhov.test_appl.data.RoomDatabase.AppLocalDatabase;
import com.shekhov.test_appl.domain.models.Quote;
import com.shekhov.test_appl.domain.repository.QuoteRepository;

public class GetQuoteFromDbUseCase {
    private QuoteRepository quoteRepository;

    public GetQuoteFromDbUseCase(QuoteRepository quoteRepository)
    {
        this.quoteRepository = quoteRepository;
    }

    public Quote getQuote()
    {
        return this.quoteRepository.getRandomQuote();
    }
}
