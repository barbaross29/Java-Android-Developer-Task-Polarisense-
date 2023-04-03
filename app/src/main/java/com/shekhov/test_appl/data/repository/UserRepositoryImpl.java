package com.shekhov.test_appl.data.repository;

import com.shekhov.test_appl.data.RoomDatabase.AppLocalDatabase;
import com.shekhov.test_appl.domain.models.User;
import com.shekhov.test_appl.domain.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {

    private AppLocalDatabase appLocalDatabase;
    public UserRepositoryImpl(AppLocalDatabase appLocalDatabase)
    {
        this.appLocalDatabase = appLocalDatabase;
    }
    @Override
    public boolean saveUser(User user) {
        if(this.appLocalDatabase.getUserDAO().insertUser(user) > 0) return true;
        return false;
    }

    @Override
    public User getUser() {
        return this.appLocalDatabase.getUserDAO().getUser();
    }

    @Override
    public boolean deleteCurrentUser() {
        this.appLocalDatabase.getUserDAO().deleteAuthUser();
        return true;
    }
}
