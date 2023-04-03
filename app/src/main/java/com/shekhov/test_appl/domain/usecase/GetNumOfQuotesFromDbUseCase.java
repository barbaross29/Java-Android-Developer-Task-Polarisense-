package com.shekhov.test_appl.domain.usecase;

import com.shekhov.test_appl.domain.models.Quote;
import com.shekhov.test_appl.domain.repository.QuoteRepository;

import java.util.List;

public class GetNumOfQuotesFromDbUseCase {
    private QuoteRepository quoteRepository;

    public GetNumOfQuotesFromDbUseCase(QuoteRepository quoteRepository)
    {
        this.quoteRepository = quoteRepository;
    }

    public int getQuotesNum()
    {
        return this.quoteRepository.getNumOfQuotes();
    }
}
