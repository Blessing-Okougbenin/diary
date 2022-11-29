package com.mine.diary.services.diary;


import com.mine.diary.data.models.Diary;
import com.mine.diary.data.models.Entry;
import com.mine.diary.dtos.requests.AddEntryRequest;
import com.mine.diary.dtos.responses.AddEntryResponse;

import java.util.List;

public interface DiaryService  {

    AddEntryResponse addEntryToDiary(AddEntryRequest addEntryRequest);
    void deleteAllEntriesInDiary();

    List<Entry> viewAllEntriesInDiary();

    void createDiary(Diary diary);

}
