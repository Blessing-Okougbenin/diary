package com.mine.diary.data.models;

import lombok.*;
import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String password;
    private String email;
    @OneToOne
    @JoinColumn(name = "user_diary_id")
    private Diary userDiary;

}
