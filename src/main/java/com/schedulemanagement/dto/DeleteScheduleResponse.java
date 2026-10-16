package com.schedulemanagement.dto;

public class DeleteScheduleResponse {

    //속성
    private final String message;



    //생성자
    public DeleteScheduleResponse(String message) {
        this.message = message;
    }


    //기능
    public String getMessage()   {
        return this.message;
    }

}
