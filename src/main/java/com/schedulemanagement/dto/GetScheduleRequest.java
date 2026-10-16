package com.schedulemanagement.dto;

public class GetScheduleRequest {

    //속성
    private String title;
    private String contents;
    private String author;
    private String password;

    //생성자

    //기능
    public String getAuthor() {
        return this.author;
    }

}
