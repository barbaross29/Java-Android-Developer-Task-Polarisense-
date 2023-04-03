package com.shekhov.test_appl.domain.usecase;

import com.shekhov.test_appl.domain.models.User;
import com.shekhov.test_appl.domain.repository.UserRepository;

public class DeleteUserFromDbUseCase {
    private UserRepository userRepository;
    public DeleteUserFromDbUseCase(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public void deleteCurrentUser()
    {
        this.userRepository.deleteCurrentUser();
    }
}
