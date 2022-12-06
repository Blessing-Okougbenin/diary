package com.mine.diary.services.user;

import com.mine.diary.data.models.Diary;
import com.mine.diary.data.models.Entry;
import com.mine.diary.data.models.User;
import com.mine.diary.data.repository.UserRepository;
import com.mine.diary.dtos.requests.AddEntryRequest;
import com.mine.diary.dtos.requests.LoginRequest;
import com.mine.diary.dtos.requests.RegisterRequest;
import com.mine.diary.dtos.responses.LoginResponse;
import com.mine.diary.dtos.responses.RegistrationResponse;
import com.mine.diary.exceptions.DiaryException;
import com.mine.diary.exceptions.PasswordException;
import com.mine.diary.services.diary.DiaryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    private final DiaryService diaryService;
    @Override
    public RegistrationResponse register(RegisterRequest registerRequest) {
        if (registerRequest.getPassword().length() < 8){
            throw new PasswordException("Password length should not be less than 5 characters");
        }

        if (!registerRequest.getPassword().equals(registerRequest.getConfirmPassword())){
            throw new PasswordException("Password and confirm password doesn't match.");
        }

          User myUser = new User();
        myUser.setCreatedDate(LocalDateTime.now());
        myUser.setEmail(registerRequest.getEmail());
        myUser.setPassword(registerRequest.getPassword());
        myUser.setFirstName(registerRequest.getFirstName());
        myUser.setLastName(registerRequest.getLastName());


        diaryService.createDiary(new Diary());
        diaryService.addEntryToDiary(new AddEntryRequest());

        userRepository.save(myUser);

        return RegistrationResponse.builder().message("Successfully registered!").build();

    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Optional<User> foundUser = userRepository.findByEmail(loginRequest.getEmail());

        if (foundUser.isPresent() && foundUser.get().getPassword().equals(loginRequest.getPassword())) successfulLogin(foundUser.get());
        System.out.println("Invalid login!");

        log.info("Welcome back :: {}", foundUser);

        return LoginResponse.builder().message("").build();
    }

    private void successfulLogin(User user) {
        LoginResponse.builder().message("You've been successfully logged in").build();
    }

    @Override
    public void delete() {
        userRepository.deleteAll();
    }


    @Override
    public List<User> viewAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateProfile() {

    }

    @Override
    public void deleteDiary() {
    }


}
