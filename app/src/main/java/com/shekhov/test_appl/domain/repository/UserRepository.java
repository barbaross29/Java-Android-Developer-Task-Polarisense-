package com.shekhov.test_appl.domain.repository;

import com.shekhov.test_appl.domain.models.User;

public interface UserRepository {

    boolean saveUser(User user);
    User getUser();
    boolean deleteCurrentUser();

}
