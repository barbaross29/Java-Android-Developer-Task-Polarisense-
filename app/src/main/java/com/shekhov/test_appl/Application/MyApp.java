package com.shekhov.test_appl.Application;


import android.app.Application;

import com.shekhov.test_appl.Core.DI.AppComponent;
import com.shekhov.test_appl.domain.ViewModels.FinishFragmentViewModel;
import com.shekhov.test_appl.domain.ViewModels.PersonalityFragmentViewModel;
import com.shekhov.test_appl.domain.ViewModels.RegActivityViewModel;
import com.shekhov.test_appl.Core.DI.DaggerAppComponent;


public class MyApp extends Application {

    public static AppComponent appComponent;

    public MyApp() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().application(this).build();
       RegActivityViewModel.appComponent = PersonalityFragmentViewModel.appComponent = FinishFragmentViewModel.appComponent = appComponent;
    }
}
