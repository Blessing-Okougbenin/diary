package com.mine.diary.services;

import com.mine.diary.dtos.requests.LoginRequest;
import com.mine.diary.dtos.requests.RegisterRequest;
import com.mine.diary.services.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest

class UserServiceImplTest {
    @Autowired
    private UserService userService;

    private RegisterRequest registerRequest;

    @BeforeEach
    void setUp() {
//        userService.delete();
        registerRequest = RegisterRequest.builder()
                .firstName("Elijah")
                .lastName("Okougbenin")
                .email("elijah@gmail.com")
                .password("heart12345")
                .confirmPassword("heart12345")
                .build();
    }

    @Test
    void register() {
        var userRegistrationResponse = userService.register(registerRequest);
        assertThat(userRegistrationResponse).isNotNull();
        assertThat(userRegistrationResponse.getMessage()).isNotNull();
        
    }


    @Test
    void login() {
        LoginRequest loginRequest = LoginRequest.builder()
                .email("elijah@gmail.com")
                .password("123456789")
                .build();
        var loggedIn = userService.login(loginRequest);
        assertThat(registerRequest.getPassword().equals(loginRequest.getPassword())).isTrue();
//        assertThat()

    }


    @Test
    void viewADairy() {
    }

    @Test
    void viewAllDairy() {
    }

    @Test
    void editDetails() {
    }

    @Test
    void deleteDetail() {
    }
}