package com.schedulemanagement.dto;


import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateScheduleResponse {

    //속성
    /**
     * 1. 응답이니 파일이 수정되면 안되므로 final 붙이기
     * 2. 응답으로 클라이언트에게 전송하는 것이니 개인정보보호로 password 포함 안함
     * 3. Id는 DB에서 생성함으로 포함 안함
    * */
    private final String title;
    private final String contents;
    private final String author;
    private final LocalDateTime createAt;
    private final LocalDateTime modifiedAt;

    //생성자
    public CreateScheduleResponse(String title, String contents, String author, LocalDateTime createAt, LocalDateTime modifiedAt) {
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
    }
}
