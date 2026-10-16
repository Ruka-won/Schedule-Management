package com.schedulemanagement.dto;


import java.time.LocalDateTime;

public class UpdateScheduleResponse {

    //속성
    private final String title;
    private final String author;
    private final LocalDateTime modifiedAt;

    //생성자
    public UpdateScheduleResponse(String title, String author, LocalDateTime modifiedAt) {
        this.title = title;
        this.author = author;
        this.modifiedAt = modifiedAt;
    }
    //기능
    public String getTitle() {
        return this.title;
    }
    public String getAuthor() {
        return this.author;
    }
    public LocalDateTime getModifiedAt() {
        return this.modifiedAt;
    }
}
