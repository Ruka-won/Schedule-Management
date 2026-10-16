package com.schedulemanagement.dto;

import java.time.LocalDateTime;

public class GetScheduleResponse {
    //속성
    private final Long id;
    private final String title;
    private final String contents;
    private final String author;
    private final LocalDateTime createAt;
    private final LocalDateTime modifiedAt;

    //생성자
    public GetScheduleResponse(Long id, String title, String contents, String author, LocalDateTime createAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
    }
    //기능
    // 1. 아이디 조회
    public Long getId() {
        return this.id;
    }
    // 2. 제목 조회
    public String getTitle() {
        return this.title;
    }
    // 3. 내용 조회
    public String getContents() {
        return this.contents;
    }
    // 4. 작성자 조회
    public String getAuthor() {
        return this.author;
    }
    // 5. 작성일 조회
    public LocalDateTime getCreateAt() {
        return this.createAt;
    }
    // 6. 수정일 조회
    public LocalDateTime getModifiedAt() {
        return this.modifiedAt;
    }


}
