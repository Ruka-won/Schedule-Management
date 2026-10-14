package com.schedulemanagement.dto;

import lombok.Getter;

@Getter
public class CreateScheduleRequest {
    //속성
    /**
     * 1. 클라이언트 작성할 값
     */
    private String title;
    private String contents;
    private String author;
    private String password;

}
