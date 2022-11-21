package com.mine.diary.services;

import com.mine.diary.data.models.Diary;
import com.mine.diary.data.models.User;
import com.mine.diary.data.repository.DiaryRepository;
import com.mine.diary.data.repository.UserRepository;
import com.mine.diary.dtos.requests.LoginRequest;
import com.mine.diary.dtos.requests.RegisterRequest;
import com.mine.diary.dtos.responses.LoginResponse;
import com.mine.diary.dtos.responses.RegistrationResponse;
import com.mine.diary.exceptions.DiaryException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final DiaryRepository diaryRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public RegistrationResponse register(RegisterRequest registerRequest) {
        Optional<User> foundUser = userRepository.findByName(registerRequest.getName());
        if (foundUser.isPresent()) throw new DiaryException(
                String.format("User with this name %s is already in use",registerRequest.getName()));
        User user = modelMapper.map(registerRequest, User.class);
        User savedUser = userRepository.save(user);
        log.info("user to be saved in db-> {}", savedUser);

        return RegistrationResponse.builder().message("Successfully registered!").build();

    }

    @Override
    public void login(LoginRequest loginRequest) {
        Optional<User> foundUser = userRepository.findByEmail(loginRequest.getEmail());

        if (foundUser.isPresent() && foundUser.get().getPassword().equals(loginRequest.getPassword())) {
            successfulLogin(foundUser.get());
            return;
        }
        LoginResponse.builder().message("Invalid login!").build();
    }

    @Override
    public void delete() {
        userRepository.deleteAll();
    }

    private void successfulLogin(User user) {
        LoginResponse.builder().message("You've been successfully logged in").build();
    }

    @Override
    public void createDiary(Diary diary) {

    }

    @Override
    public List<Diary> viewAllDairy() {
        return diaryRepository.findAll();
    }

    @Override
    public void updateProfile() {

    }

    @Override
    public void deleteDiary() {

    }


}
