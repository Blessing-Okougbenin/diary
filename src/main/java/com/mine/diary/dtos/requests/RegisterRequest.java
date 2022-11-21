package com.mine.diary.dtos.requests;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
}
