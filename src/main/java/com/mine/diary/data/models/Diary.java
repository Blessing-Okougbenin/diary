package com.mine.diary.data.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "diary_id", nullable = false)
    private Long diary_id;
    private String name;
    private LocalDateTime dateCreated;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Entry> entries = new ArrayList<>();
}
