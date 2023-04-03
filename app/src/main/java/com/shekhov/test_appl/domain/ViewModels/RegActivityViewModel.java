package com.shekhov.test_appl.domain.ViewModels;

import androidx.lifecycle.ViewModel;

import com.shekhov.test_appl.Core.DI.AppComponent;
import com.shekhov.test_appl.Core.DI.DaggerRegisterActivityVMComponent;
import com.shekhov.test_appl.Core.DI.RegisterActivityVMComponent;
import com.shekhov.test_appl.data.RoomDatabase.AppLocalDatabase;
import com.shekhov.test_appl.domain.models.Quote;
import com.shekhov.test_appl.domain.models.User;
import com.shekhov.test_appl.domain.repository.QuoteRepository;
import com.shekhov.test_appl.domain.repository.UserRepository;
import com.shekhov.test_appl.domain.usecase.DeleteUserFromDbUseCase;
import com.shekhov.test_appl.domain.usecase.GetNumOfQuotesFromDbUseCase;
import com.shekhov.test_appl.domain.usecase.GetQuoteFromDbUseCase;
import com.shekhov.test_appl.domain.usecase.GetUserFromDbUseCase;
import com.shekhov.test_appl.domain.usecase.InsertQuoteIntoDbUseCase;
import com.shekhov.test_appl.domain.usecase.InsertUserIntoDbUseCase;

import java.util.ArrayList;
import java.util.List;

public class RegActivityViewModel extends ViewModel {

    //some LiveData, in this app not needed, because we dont observe changing of DB tables

    public static AppComponent appComponent;
    private RegisterActivityVMComponent daggerRegisterActivityVMComponent;
    private User user;
    private AppLocalDatabase appLocalDatabase;

    //repositories
    private UserRepository userRepository;
    private QuoteRepository quoteRepository;


    //usecases
    private InsertUserIntoDbUseCase insertUserIntoDbUseCase;
    private InsertQuoteIntoDbUseCase insertQuoteIntoDbUseCase;
    private GetQuoteFromDbUseCase getQuoteFromDbUseCase;
    private GetNumOfQuotesFromDbUseCase getNumOfQuotesFromDbUseCase;
    private GetUserFromDbUseCase getUserFromDbUseCase;
    private DeleteUserFromDbUseCase deleteUserFromDbUseCase;

    public RegActivityViewModel() {
        super();
        user = new User();
        daggerRegisterActivityVMComponent = DaggerRegisterActivityVMComponent.builder().appComponent(appComponent).build();
        getNumOfQuotesFromDbUseCase = daggerRegisterActivityVMComponent.getGetNumOfQuotesFromDbUseCase();
        getUserFromDbUseCase = daggerRegisterActivityVMComponent.getGetUserFromDbUseCase();
        insertQuoteIntoDbUseCase = daggerRegisterActivityVMComponent.getInsertQuoteIntoDbUseCase();
        deleteUserFromDbUseCase = daggerRegisterActivityVMComponent.getDeleteUserFromDbUseCase();
    }

    private int getNumOfQuotes()
    {
        return this.getNumOfQuotesFromDbUseCase.getQuotesNum();
    }

    public User getUser()
    {
        return this.getUserFromDbUseCase.getUser();
    }

    private void insertQuotes(List<Quote> quotes)
    {
        this.insertQuoteIntoDbUseCase.insertQuote(quotes);
    }
    public void deleteCurrentUser()
    {
        this.deleteUserFromDbUseCase.deleteCurrentUser();
    }
    public void insertQuotes()
    {
        if(getNumOfQuotes() < 5) {
            ArrayList<Quote> quotes = new ArrayList<Quote>();
            quotes.add(new Quote("Стремитесь не к успеху, а к ценностям, которые он дает.", "Альберт Эйнштейн"));
            quotes.add(new Quote("Сложнее всего начать действовать, все остальное зависит только от упорства.", "Амелия Эрхарт"));
            quotes.add(new Quote("Жизнь - это то, что с тобой происходит, пока ты строишь планы.", "Джон Леннон"));
            quotes.add(new Quote("Логика может привести Вас от пункта А к пункту Б, а воображение — куда угодно.", "Альберт Эйнштейн"));
            quotes.add(new Quote("Через 20 лет вы будете больше разочарованы теми вещами, которые вы не делали, чем теми, которые вы сделали. Так отчальте от тихой пристани. Почувствуйте попутный ветер в вашем парусе. Двигайтесь вперед, действуйте, открывайте!", "Марк Твен"));
            insertQuotes(quotes);
        }
    }
}
