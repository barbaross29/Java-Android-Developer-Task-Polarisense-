package com.shekhov.test_appl.Core.DI;

import android.content.Context;

import com.shekhov.test_appl.data.RoomDatabase.AppLocalDatabase;
import com.shekhov.test_appl.data.repository.QuoteRepositoryImpl;
import com.shekhov.test_appl.data.repository.UserRepositoryImpl;
import com.shekhov.test_appl.domain.repository.QuoteRepository;
import com.shekhov.test_appl.domain.repository.UserRepository;
import com.shekhov.test_appl.domain.usecase.GetQuoteFromDbUseCase;
import com.shekhov.test_appl.domain.usecase.InsertUserIntoDbUseCase;

import javax.inject.Scope;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

@FinishFragmentVMComponent.FinishFragmentVMScope
@Component(dependencies = {AppComponent.class}, modules = FinishFragmentVMModule.class)
public interface FinishFragmentVMComponent {

    @Component.Builder
    interface Builder
    {
        Builder appComponent(AppComponent appComponent);

        FinishFragmentVMComponent build();
    }

    AppLocalDatabase getDB();
    GetQuoteFromDbUseCase getQuoteFromDbUseCase();
    @AppComponent.AppScope
    Context appContext();

    @Scope
    public @interface FinishFragmentVMScope{}
}

@Module
class FinishFragmentVMModule {
    @Provides
    @FinishFragmentVMComponent.FinishFragmentVMScope
    AppLocalDatabase provideAppLocalDatabase(@AppComponent.ApplicationContext Context appContext) {
        return AppLocalDatabase.getINSTANCE(appContext);
    }

    @Provides
    Context provideAppContext(@AppComponent.ApplicationContext Context appContext) {
        return appContext;
    }
    @Provides
    @FinishFragmentVMComponent.FinishFragmentVMScope
    QuoteRepository provideQuoteRepository(AppLocalDatabase appLocalDatabase)
    {
        return new QuoteRepositoryImpl(appLocalDatabase);
    }
    @Provides
    @FinishFragmentVMComponent.FinishFragmentVMScope
    GetQuoteFromDbUseCase provideGetQuoteFromDbUseCase(QuoteRepository quoteRepository)
    {
        return new GetQuoteFromDbUseCase(quoteRepository);
    }
}

