package com.mine.diary.dtos.requests;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateDiaryRequest {
    private String name;
    private LocalDateTime dateCreated;
}
