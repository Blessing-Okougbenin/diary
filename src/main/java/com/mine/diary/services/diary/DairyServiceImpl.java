package com.mine.diary.services.diary;

import com.mine.diary.data.models.Diary;
import com.mine.diary.data.models.Entry;
import com.mine.diary.data.models.User;
import com.mine.diary.data.repository.DiaryRepository;
import com.mine.diary.data.repository.EntryRepository;
import com.mine.diary.data.repository.UserRepository;
import com.mine.diary.dtos.requests.AddEntryRequest;
import com.mine.diary.dtos.responses.AddEntryResponse;
import com.mine.diary.exceptions.EntryCreationException;
import com.mine.diary.exceptions.EntryException;
import com.mine.diary.exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class DairyServiceImpl implements DiaryService{

    private final EntryRepository entryRepository;

    private final DiaryRepository diaryRepository;

    private final UserRepository userRepository;

    @Override
    public AddEntryResponse addEntryToDiary(AddEntryRequest addEntryRequest) {

        Optional<User> user = Optional.ofNullable(userRepository.findById(addEntryRequest.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found")));
        Optional<Entry> foundEntry = Optional.ofNullable(entryRepository.findById(addEntryRequest.getEntryId())
                .orElseThrow(()-> new EntryException("Entry not found")));

        if (user.isEmpty()  && foundEntry.isEmpty()) {
            throw new EntryCreationException("You can't create an entry");
        }
         Entry newEntry = new Entry();
        newEntry.setId(addEntryRequest.getEntryId());
        newEntry.setTitle(addEntryRequest.getTitle());
        newEntry.setBody(addEntryRequest.getBody());

         entryRepository.save(newEntry);

        return AddEntryResponse.builder().messsage("Successfully created an entry").build();
    }

    @Override
    public void deleteAllEntriesInDiary() {
        entryRepository.deleteAll();
    }

    @Override
    public List<Entry> viewAllEntriesInDiary() {
       return entryRepository.findAll();
    }

    @Override
    public void createDiary(Diary diary) {

        diaryRepository.save(diary);
    }


}
