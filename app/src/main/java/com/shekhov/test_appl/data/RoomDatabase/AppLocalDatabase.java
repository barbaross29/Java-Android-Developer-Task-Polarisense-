package com.shekhov.test_appl.data.RoomDatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.shekhov.test_appl.Core.DI.AppComponent;
import com.shekhov.test_appl.data.RoomDatabase.DAOS.QuotesDAO;
import com.shekhov.test_appl.data.RoomDatabase.DAOS.UserDAO;
import com.shekhov.test_appl.domain.models.Quote;
import com.shekhov.test_appl.domain.models.User;


@Database(entities = {User.class, Quote.class}, version = 1)
public abstract class AppLocalDatabase extends RoomDatabase {

    private UserDAO userDAO;
    private QuotesDAO quotesDAO;

    private static AppLocalDatabase INSTANCE;
    public static AppLocalDatabase getINSTANCE(@AppComponent.ApplicationContext Context appContext)
    {
        if(INSTANCE == null)
        {
            INSTANCE = Room.databaseBuilder(appContext, AppLocalDatabase.class,"LocalSQLiteDB").allowMainThreadQueries().build();
            INSTANCE.userDAO = INSTANCE.getUserDAO();
            INSTANCE.quotesDAO = INSTANCE.getQuotesDAO();
        }
        return INSTANCE;
    }

    public abstract UserDAO getUserDAO();
    public abstract QuotesDAO getQuotesDAO();

}
