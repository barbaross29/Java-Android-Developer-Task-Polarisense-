package com.shekhov.test_appl.Core.DI;

import android.content.Context;

import com.shekhov.test_appl.data.RoomDatabase.AppLocalDatabase;
import com.shekhov.test_appl.data.repository.UserRepositoryImpl;
import com.shekhov.test_appl.domain.repository.UserRepository;
import com.shekhov.test_appl.domain.usecase.InsertUserIntoDbUseCase;

import javax.inject.Scope;

import dagger.Component;
import dagger.Module;
import dagger.Provides;


@PersonalityFragmentVMComponent.PersonalityFragmentScope
@Component(dependencies = {AppComponent.class}, modules = PersonalityFragmentModule.class)
public interface PersonalityFragmentVMComponent {

    @Component.Builder
    interface Builder
    {
        // @BindsInstance
        //Builder application(Application application);

        Builder appComponent(AppComponent appComponent);

        PersonalityFragmentVMComponent build();
    }

    //    NavController getNavController();
    AppLocalDatabase getDB();
    InsertUserIntoDbUseCase getInsertUserIntoDBUseCase();
//    Model getModel();

    @AppComponent.AppScope
    Context appContext();

    @Scope
    public @interface PersonalityFragmentScope{}
}

@Module
class PersonalityFragmentModule {
    @Provides
    @PersonalityFragmentVMComponent.PersonalityFragmentScope
    AppLocalDatabase provideAppLocalDatabase(@AppComponent.ApplicationContext Context appContext) {
        return AppLocalDatabase.getINSTANCE(appContext);
    }

    @Provides
    Context provideAppContext(@AppComponent.ApplicationContext Context appContext) {
        return appContext;
    }
    @Provides
    UserRepository provideUserRepository(AppLocalDatabase appLocalDatabase)
    {
        return new UserRepositoryImpl(appLocalDatabase);
    }
    @Provides
    InsertUserIntoDbUseCase provideInsertUser(UserRepository userRepository)
    {
        return  new InsertUserIntoDbUseCase(userRepository);
    }
}

