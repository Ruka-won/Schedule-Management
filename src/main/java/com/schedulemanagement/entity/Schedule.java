package com.schedulemanagement.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "schedules")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
/*
 * 1. Jpa Auditing을 이용하여 createAt, modifiedAt 자동 생성
 */
public class Schedule extends BaseEntity{

    //속성
    /*
     * 1. Id 고유 식별값으로 자동 생성 관리
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 200, nullable = true) // 제목은 작성하되, 내용은 비워나도 되는 것으로 설정
    private String contents;

    @Column(length = 10, nullable = true)
    private String author;

    @Column(length = 100, nullable = false) // 비밀번호는 널값을 허용하지않고 필수로 작성하게 만들기
    private String password;

    //생성자
    public Schedule(String title, String contents, String author, String password) {
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.password = password;
    }

    //기능


}
