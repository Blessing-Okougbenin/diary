package com.mine.diary.dtos.requests;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String confirmPassword;
}
