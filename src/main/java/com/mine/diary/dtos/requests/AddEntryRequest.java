package com.mine.diary.dtos.requests;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddEntryRequest {

    private Long entryId;

    private Long userId;

    private  String title;

    private  String body;
}
