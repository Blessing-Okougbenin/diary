package com.mine.diary.services.user;

import com.mine.diary.data.models.User;
import com.mine.diary.dtos.requests.LoginRequest;
import com.mine.diary.dtos.requests.RegisterRequest;
import com.mine.diary.dtos.responses.LoginResponse;
import com.mine.diary.dtos.responses.RegistrationResponse;

import java.util.List;

public interface UserService {
    RegistrationResponse register(RegisterRequest registerRequest);
    void updateProfile();

    List<User> viewAllUsers();

    void deleteDiary();

    LoginResponse login(LoginRequest loginRequest);

    void delete();
}
