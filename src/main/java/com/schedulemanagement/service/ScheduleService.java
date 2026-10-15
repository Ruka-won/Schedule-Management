package com.schedulemanagement.service;

import com.schedulemanagement.dto.CreateScheduleRequest;
import com.schedulemanagement.dto.CreateScheduleResponse;
import com.schedulemanagement.entity.Schedule;
import com.schedulemanagement.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    //속성
    private final ScheduleRepository scheduleRepository;

    //생성자

    //기능
    /**
     * 1. 트랜잭션으로 감싸줘서 모두 성공 모두 실패 탑재
     * 2. 호출한 곳으로 return 해주는 것 (Request 요청한 것을 저장도하고 응답)
     * 3. `new CreateScheduleResponse` = `CreateSchedule createSchedule = new CreateSchedule` 같은 의미
     * */
    // 1. 일정 생성
    @Transactional
    public CreateScheduleResponse save(CreateScheduleRequest request) {
        // 1-1. 클라이언트 요청으로 받아온 데이터
        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getContents(),
                request.getAuthor(),
                request.getPassword()
        );
        // 1-2. Entity를 통해 Database에 저장
        Schedule savedSchedule = scheduleRepository.save(schedule);

        // 1-3. 응답 반환
        return new CreateScheduleResponse(
                savedSchedule.getTitle(),
                savedSchedule.getContents(),
                savedSchedule.getAuthor(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getModifiedAt()
        );


    }
}
