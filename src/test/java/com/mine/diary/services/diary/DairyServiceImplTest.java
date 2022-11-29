package com.mine.diary.services.diary;

import com.mine.diary.data.repository.EntryRepository;
import com.mine.diary.dtos.requests.AddEntryRequest;
import com.mine.diary.services.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class DairyServiceImplTest {

    @Autowired
    private DiaryService diaryService;

    @Autowired
    private UserService userService;

    @Autowired
    private EntryRepository diaryRepo;


    @BeforeEach
    void setUp() {
//        userService.delete();
//        RegisterRequest registerRequest = RegisterRequest.builder()
//                .name("Michael")
//                .email("Michael@gmail.com")
//                .password("123456")
//                .build();
//        userService.register(registerRequest);
//        entry = new Entry();
    }

    @Test
    void addEntry() {
        AddEntryRequest addEntryRequest =
                AddEntryRequest.builder()
                        .userId(userService.viewAllUsers().get(userService.viewAllUsers().size()-1).getId())
                        .entryId(diaryService.viewAllEntriesInDiary().get(diaryService.viewAllEntriesInDiary().size()-1).getId())
                        .title("My Semicolon Experience")
                        .body("Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                                    "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                                    "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut" +
                                    " aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate " +
                                    "velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, " +
                                    "sunt in culpa qui officia deserunt mollit anim id est laborum").build();
        var addedEntry = diaryService.addEntryToDiary(addEntryRequest);

        assertThat(addedEntry.getMesssage()).isNotNull();
        assertThat(diaryRepo.count()).isGreaterThan(1L);

    }
}