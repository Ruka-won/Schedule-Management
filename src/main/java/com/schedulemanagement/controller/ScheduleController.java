package com.schedulemanagement.controller;

import com.schedulemanagement.dto.*;
import com.schedulemanagement.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    // 속성
    /*
     *  1. Controller -> Service -> Repository 순서대로 의존하기
     */
    private final ScheduleService scheduleService;


    //생성자


    //기능
    // 1. 일정 생성
    /*
     *  1-1. 공통 경로 생성하여 중복 작성 방지
     *  1-2. 생성을 위한 어노테이션 준비
     */
    @PostMapping("/schedules")
    public ResponseEntity<CreateScheduleResponse> createSchedule(
            @RequestBody CreateScheduleRequest request) {
        /*
         * 1-4. Dto 데이터 전송 객체 생성
         * 1-5. 클라이언트 요청한 데이터 받기
         * 1-6. status code 설정하면서 Service에게 비즈니스 로직 처리 전달
         */
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.save(request));

    }

     // 2. 일정 단건 조회
    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<GetScheduleResponse> getSchedule(@PathVariable Long scheduleId) {
        /*
        *  2-1. 클라이언트에게 받은 아이디 값을 통해서 조회를 한다.
         * 2-2. PathVariable을 통해서 고유값 아이디 받아오기
         * 2-3. 받아온 값 디버깅 과정 출력으로 확인하기 System.out.println("id" + scheduleId);
         * 2-4. 받아온 아이디값을 서비스을 통해서 조회하며 해당값 가져오기.
         */
        GetScheduleResponse getScheduleResponse = scheduleService.findOne(scheduleId);
        /*
         * 2-5. Dto 전달된 거 받기
         * 2-6. 제대로 전달 됐는지 값 확인하기 디버깅 과정
         * System.out.println("getScheduleResponse" + getScheduleResponse.getId());
         * 2-7. 클라이언트에게 받아온 값 돌려주기.
         */
        return ResponseEntity.status(HttpStatus.OK).body(getScheduleResponse);

    }
    // 3. 일정 전체 조회
    @GetMapping("/schedules")
    public ResponseEntity <List<GetScheduleResponse>> getAllSchedule(@RequestParam(required = false) String author) {
        /*
         *  3-1. 전체값을 조회하는 것이지만 작성자 입력값이 있으면 조건에 맞춰 조회하기위해 RequestParam으로 받아오기
         *  3-2. required = false는 값이 비어있어도 통과시키기 위한 설정
         *  3-3. 작성자 값을 가지고 서비스에서 전체 조회 호출
         */
        List<GetScheduleResponse> authorList = scheduleService.findAll(author);
        return ResponseEntity.status(HttpStatus.OK).body(authorList);
    }

    // 4. 일정 수정
    @PatchMapping("/schedules/{scheduleId}")
    /*
     * 4-1. 고유값을 통해서 수정
     * 4-2. 수정받을 값 클라이언트에게 받기
     */
    public ResponseEntity<UpdateScheduleResponse> updateSchedule(
            @PathVariable Long scheduleId,
            @RequestBody UpdateScheduleRequest request
    ) {
        /*
         * 4-3. Dto로 포장 받은 값 저장하고 클라이언트에게 전달
         */
        UpdateScheduleResponse updateScheduleResponse = scheduleService.updateSchedule(scheduleId, request);
        return ResponseEntity.status(HttpStatus.OK).body(updateScheduleResponse);
    }

    // 5. 일정 삭제
    @DeleteMapping("/schedules/{scheduleId}")
    // 5-1. 클라이언트에게 삭제되었다는 메세지를 담아주기 위해서 Dto 생성
    public ResponseEntity<DeleteScheduleResponse> deleteSchedule(
            @PathVariable Long scheduleId,
            @RequestParam String password
    )
    {
        // 5-2. 삭제할 고유 식별값 서비스로 전달
        DeleteScheduleResponse deleteScheduleResponse = scheduleService.delete(scheduleId, password);


        return ResponseEntity.status(HttpStatus.OK).body(deleteScheduleResponse);


    }
}
