package com.shekhov.test_appl.presentation;

import android.content.Context;

import com.shekhov.test_appl.data.RoomDatabase.AppLocalDatabase;
import com.shekhov.test_appl.domain.models.User;

import javax.inject.Inject;

public class Model {
    private static Model INSTANCE;
    private AppLocalDatabase appLocalDatabase;
    public User newUser;

    public static Model getINSTANCE(Context context)
    {
        if(INSTANCE == null)
        {
            INSTANCE = new Model();
            INSTANCE.appLocalDatabase = AppLocalDatabase.getINSTANCE(context);
        }
        return INSTANCE;
    }
    @Inject
    public Model(){newUser = new User();}
    public AppLocalDatabase getAppLocalDatabase()
    {
        return this.appLocalDatabase;
    }
}
