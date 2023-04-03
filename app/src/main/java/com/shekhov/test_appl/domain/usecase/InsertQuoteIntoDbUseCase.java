package com.shekhov.test_appl.domain.usecase;

import com.shekhov.test_appl.domain.models.Quote;
import com.shekhov.test_appl.domain.repository.QuoteRepository;

import java.util.List;

public class InsertQuoteIntoDbUseCase {
    private QuoteRepository quoteRepository;

    public InsertQuoteIntoDbUseCase(QuoteRepository quoteRepository)
    {
        this.quoteRepository = quoteRepository;
    }

    public boolean insertQuote(List<Quote> quotes)
    {
        return this.quoteRepository.saveQuotes(quotes);
    }
}
