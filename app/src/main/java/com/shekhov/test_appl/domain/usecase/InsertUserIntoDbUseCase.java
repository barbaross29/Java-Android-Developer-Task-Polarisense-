package com.shekhov.test_appl.domain.usecase;

import com.shekhov.test_appl.domain.models.User;
import com.shekhov.test_appl.domain.repository.UserRepository;

public class InsertUserIntoDbUseCase {
    private UserRepository userRepository;

    public InsertUserIntoDbUseCase(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public void saveUser(User user)
    {
        this.userRepository.saveUser(user);
    }
}
