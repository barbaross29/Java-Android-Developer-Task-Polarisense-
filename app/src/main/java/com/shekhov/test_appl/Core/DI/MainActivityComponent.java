package com.shekhov.test_appl.Core.DI;

import android.content.Context;

import com.shekhov.test_appl.presentation.Model;

import javax.inject.Scope;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

@MainActivityComponent.MainActivityScope
@Component(dependencies = {AppComponent.class}, modules = {MainActivityModule.class})
public interface MainActivityComponent {
    @Component.Builder
    interface Builder
    {
       // @BindsInstance
        //Builder application(Application application);
        Builder appComponent(AppComponent appComponent);
        MainActivityComponent build();
    }

    Model getModel();

    @Scope
    public @interface MainActivityScope{}
}

@Module
class MainActivityModule
{
    @Provides
    @MainActivityComponent.MainActivityScope
    Model provideModule(@AppComponent.ApplicationContext Context appContext)
    {
        return Model.getINSTANCE(appContext);
    }
}