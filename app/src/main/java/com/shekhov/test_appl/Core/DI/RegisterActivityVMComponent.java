package com.shekhov.test_appl.Core.DI;

import android.app.Activity;
import android.content.Context;


import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.shekhov.test_appl.data.RoomDatabase.AppLocalDatabase;
import com.shekhov.test_appl.R;
import com.shekhov.test_appl.data.repository.QuoteRepositoryImpl;
import com.shekhov.test_appl.data.repository.UserRepositoryImpl;
import com.shekhov.test_appl.domain.repository.QuoteRepository;
import com.shekhov.test_appl.domain.repository.UserRepository;
import com.shekhov.test_appl.domain.usecase.DeleteUserFromDbUseCase;
import com.shekhov.test_appl.domain.usecase.GetNumOfQuotesFromDbUseCase;
import com.shekhov.test_appl.domain.usecase.GetUserFromDbUseCase;
import com.shekhov.test_appl.domain.usecase.InsertQuoteIntoDbUseCase;
import com.shekhov.test_appl.presentation.Model;

import javax.inject.Scope;

import dagger.Binds;
import dagger.BindsInstance;
import dagger.Component;
import dagger.Module;
import dagger.Provides;

@RegisterActivityVMComponent.RegiseterActivityScope
@Component(dependencies = {AppComponent.class}, modules = RegisterActivityModule.class)
public interface RegisterActivityVMComponent {

    @Component.Builder
    interface Builder
    {
       // @BindsInstance
        //Builder application(Application application);

        Builder appComponent(AppComponent appComponent);

        RegisterActivityVMComponent build();
    }

//    NavController getNavController();
    AppLocalDatabase getDB();
    InsertQuoteIntoDbUseCase getInsertQuoteIntoDbUseCase();
    GetUserFromDbUseCase getGetUserFromDbUseCase();
    GetNumOfQuotesFromDbUseCase getGetNumOfQuotesFromDbUseCase();
    DeleteUserFromDbUseCase getDeleteUserFromDbUseCase();
//    Model getModel();

    @AppComponent.AppScope
    Context appContext();

    @Scope
    public @interface RegiseterActivityScope{}
}

@Module
class RegisterActivityModule
{
    @Provides
    @RegisterActivityVMComponent.RegiseterActivityScope
    AppLocalDatabase provideAppLocalDatabase(@AppComponent.ApplicationContext Context appContext)
    {
        return AppLocalDatabase.getINSTANCE(appContext);
    }

    @Provides
    Context provideAppContext(@AppComponent.ApplicationContext Context appContext) {
        return appContext;
    }

    @Provides
    @RegisterActivityVMComponent.RegiseterActivityScope
    QuoteRepository provideQuoteRepository(AppLocalDatabase appLocalDatabase)
    {
        return new QuoteRepositoryImpl(appLocalDatabase);
    }
    @Provides
    @RegisterActivityVMComponent.RegiseterActivityScope
    UserRepository provideUserRepository(AppLocalDatabase appLocalDatabase)
    {
        return new UserRepositoryImpl(appLocalDatabase);
    }

    @Provides
    @RegisterActivityVMComponent.RegiseterActivityScope
    InsertQuoteIntoDbUseCase provideInsertQuoteIntoDbUseCase(QuoteRepository quoteRepository)
    {
        return new InsertQuoteIntoDbUseCase(quoteRepository);
    }
    @Provides
    @RegisterActivityVMComponent.RegiseterActivityScope
    GetUserFromDbUseCase provideGetUserFromDbUseCase(UserRepository userRepository)
    {
        return new GetUserFromDbUseCase(userRepository);
    }
    @Provides
    @RegisterActivityVMComponent.RegiseterActivityScope
    GetNumOfQuotesFromDbUseCase provideGetNumOfQuotesFromDbUseCase(QuoteRepository quoteRepository)
    {
        return new GetNumOfQuotesFromDbUseCase(quoteRepository);
    }
    @Provides
    @RegisterActivityVMComponent.RegiseterActivityScope
    DeleteUserFromDbUseCase provideDeleteUserFromDbUseCase(UserRepository userRepository)
    {
        return new DeleteUserFromDbUseCase(userRepository);
    }

//    @Provides
//    @RegisterActivityVMComponent.HomeActivityScope
//    Model provideModel(@AppComponent.ApplicationContext Context appContext)
//    {
//        return Model.getINSTANCE(appContext);
//    }
//    @Provides
//    @RegisterActivityVMComponent.HomeActivityScope
//    NavController provideNavController(Activity activity)
//    {
//        return Navigation.findNavController(activity, R.id.main_activity_nav_host_fragment);
//    }

}
