package com.mine.diary.services;

import com.mine.diary.data.models.Diary;
import com.mine.diary.dtos.requests.LoginRequest;
import com.mine.diary.dtos.requests.RegisterRequest;
import com.mine.diary.dtos.responses.RegistrationResponse;

import java.util.List;

public interface UserService {
    RegistrationResponse register(RegisterRequest registerRequest);
    void updateProfile();
    void createDiary(Diary diary);
    List<Diary> viewAllDairy();
    void deleteDiary();

    void login(LoginRequest loginRequest);

    void delete();
}
