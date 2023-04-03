package com.shekhov.test_appl.domain.ViewModels;
import androidx.lifecycle.ViewModel;

import com.shekhov.test_appl.Core.DI.AppComponent;
import com.shekhov.test_appl.Core.DI.DaggerPersonalityFragmentVMComponent;
import com.shekhov.test_appl.Core.DI.PersonalityFragmentVMComponent;
import com.shekhov.test_appl.data.RoomDatabase.AppLocalDatabase;
import com.shekhov.test_appl.domain.models.User;
import com.shekhov.test_appl.domain.repository.QuoteRepository;
import com.shekhov.test_appl.domain.repository.UserRepository;
import com.shekhov.test_appl.domain.usecase.InsertUserIntoDbUseCase;

public class PersonalityFragmentViewModel extends ViewModel {

    //some LiveData, in this app not needed, because we dont observe changing of DB tables

    public static AppComponent appComponent;
    private PersonalityFragmentVMComponent daggerPersonalityVMComponent;
    private AppLocalDatabase appLocalDatabase;

    //repositories
    private UserRepository userRepository;
    private QuoteRepository quoteRepository;


    //usecases
    private InsertUserIntoDbUseCase insertUserIntoDbUseCase;

    public PersonalityFragmentViewModel()
    {
        daggerPersonalityVMComponent = DaggerPersonalityFragmentVMComponent.builder().appComponent(appComponent).build();
        insertUserIntoDbUseCase = daggerPersonalityVMComponent.getInsertUserIntoDBUseCase();
    }

    public void insertUser(User user)
    {
        insertUserIntoDbUseCase.saveUser(user);
    }
}
