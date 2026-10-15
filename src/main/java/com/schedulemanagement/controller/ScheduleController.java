package com.schedulemanagement.controller;

import com.schedulemanagement.dto.CreateScheduleRequest;
import com.schedulemanagement.dto.CreateScheduleResponse;
import com.schedulemanagement.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    // 속성
    /**
     *  1. Controller -> Service -> Repository 순서대로 의존하기
     **/
    private final ScheduleService scheduleService;


    //생성자


    //기능

    // 공통 url 경로 생성
    @RequestMapping("/schedules")
    // 1. 일정 생성
    @PostMapping
    public ResponseEntity<CreateScheduleResponse> createSchedule(
            @RequestBody CreateScheduleRequest request) {
        // 반환 body에 상태 값을 설정해주면서 저장할 수 있게 Service 호출
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.save(request));

    }

    // 2. 일정 단 건 조회
    @GetMapping
    public ResponseEntity<>



}
