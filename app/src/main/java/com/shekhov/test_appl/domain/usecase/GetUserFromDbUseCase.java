package com.shekhov.test_appl.domain.usecase;

import com.shekhov.test_appl.domain.models.User;
import com.shekhov.test_appl.domain.repository.UserRepository;

public class GetUserFromDbUseCase {
    private UserRepository userRepository;
    public GetUserFromDbUseCase(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public User getUser()
    {
        return this.userRepository.getUser();
    }
}
