package com.schedulemanagement.service;

import com.schedulemanagement.dto.CreateScheduleRequest;
import com.schedulemanagement.dto.CreateScheduleResponse;
import com.schedulemanagement.entity.Schedule;
import com.schedulemanagement.repository.ScheduleRepository;
import lombok.Getter;
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
     * 1. 일정 생성
     * 2. 트랜잭션으로 감싸줘서 모두 성공 모두 실패 탑재?
     * 3. 호출한 곳으로 return 해주는 것 (Request 요청한 것을 저장도하고 응답)
     * 4. `new CreateScheduleResponse` = `CreateSchedule createSchedule = new CreateSchedule` 같은 의미
     * */
    @Transactional
    public CreateScheduleResponse save(CreateScheduleRequest request) {
        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getContents(),
                request.getAuthor(),
                request.getPassword()
        );
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new CreateScheduleResponse(
                savedSchedule.getTitle(),
                savedSchedule.getContents(),
                savedSchedule.getAuthor(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getModifiedAt()
        );


    }
}
