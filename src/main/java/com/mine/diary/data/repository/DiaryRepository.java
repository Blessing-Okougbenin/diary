package com.mine.diary.data.repository;

import com.mine.diary.data.models.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
}
