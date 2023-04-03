package com.shekhov.test_appl.data.RoomDatabase.DAOS;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.shekhov.test_appl.domain.models.User;

@Dao
public interface UserDAO {

    @Insert
    long insertUser(User user);

    @Query("SELECT * FROM User")
    User getUser();

    @Query("DELETE FROM User")
    void deleteAuthUser();
}
