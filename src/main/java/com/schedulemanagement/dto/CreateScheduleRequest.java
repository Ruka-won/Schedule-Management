package com.schedulemanagement.dto;


public class CreateScheduleRequest {
    //속성
    /**
     * 1. 클라이언트 작성할 값
     */
    private String title;
    private String contents;
    private String author;
    private String password;


    //생성자


    //기능
    public String getTitle() {
        return this.title;
    }
    public String getContents() {
        return this.contents;
    }
    public String getAuthor() {
        return this.author;
    }
    public String getPassword() {
        return this.password;
    }
}
