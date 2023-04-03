package com.shekhov.test_appl.Core.DI;

import android.app.Application;
import android.content.Context;

import javax.inject.Qualifier;
import javax.inject.Scope;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Module;
import dagger.Provides;

@AppComponent.AppScope
@Component( modules = AppModule.class)
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }

    @ApplicationContext
    Context appContext();

    @Qualifier
    public @interface ApplicationContext{}
    @Scope
    public @interface AppScope{}
}

@Module
class AppModule
{
    @AppComponent.AppScope
    @AppComponent.ApplicationContext
    @Provides
    public Context provideApplicationContext(Application application) {
        return application;
    }
}
