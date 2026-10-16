package com.schedulemanagement.service;

import com.schedulemanagement.dto.*;
import com.schedulemanagement.entity.Schedule;
import com.schedulemanagement.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    //속성
    private final ScheduleRepository scheduleRepository;

    //생성자

    //기능
    // 1. 일정 생성
    /*
     * 1. 트랜잭션으로 감싸줘서 모두 성공 모두 실패 탑재
     * 2. 호출한 곳으로 return 해주는 것 (Request 요청한 것을 저장도하고 응답)
     * 3. `new CreateScheduleResponse` = `CreateSchedule createSchedule = new CreateSchedule` 같은 의미
     * */
    @Transactional
    public CreateScheduleResponse save(CreateScheduleRequest request) {
        /*
         * 1-1. 클라이언트 요청으로 받아온 데이터베이스에 저장하기 위해 Entity로 감싸기
         */
        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getContents(),
                request.getAuthor(),
                request.getPassword()
        );
        /*
         * 1-2. Entity를 통해 감싼 데이터 Database에 저장
         */
        Schedule savedSchedule = scheduleRepository.save(schedule);

        /*
         * 1-3. 클라이언트에게 응답 반환할 값 설정하기
         * 1-4. password 보완 관련하여 응답에서 제외
         */
        return new CreateScheduleResponse(
                savedSchedule.getId(),
                savedSchedule.getTitle(),
                savedSchedule.getContents(),
                savedSchedule.getAuthor(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getModifiedAt()
        );


    }
    // 2. 일정 단 건 조회
    @Transactional(readOnly = true)
    public GetScheduleResponse findOne(Long scheduleId) {
        /*
         * 2-1. controller에서 받은 고유값 받기
         * 2-2. 디버깅 과정 고유값이 넘어왔는지 확인 System.out.println("serviceid" + scheduleId);
         * 2-3. Repository에서 저장된 고유값 조회하고 받아서 schedule에 저장
         */
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("해당 일정이 존재하지 않습니다.")
        );
        /*
         * 2-4. 저장된 schedule 바구니에 물건이 담겨있는지 확인System.out.println(schedule.getId());
         * 2-5. 장바구니에 담기 정보들을 Dto로 감싸서 반환해주기
         */
        return new GetScheduleResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContents(),
                schedule.getAuthor(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }
    // 3. 일정 전체 조회
    @Transactional(readOnly = true)
    public List<GetScheduleResponse> findAll(String author) {
        // 1. 수정일 기준 내림차순 정렬(sort.by 이용)
        Sort sort = Sort.by(Sort.Direction.DESC, "modifiedAt");

        // 2. 모든 일정 데이터 가져오고 수정일 기준으로 내림차순 정렬하기
        List<Schedule> scheduleAll = scheduleRepository.findAll(sort);

        // 3. 작성자 기준으로 조회된 것과 전체조회가 된 것을 구분하기위한 박스 준비
        List<GetScheduleResponse> filterList = new ArrayList<>();

        // 4. 전체 일정 하나하나 가져오기
        for (Schedule schedule : scheduleAll) {
            // 4-1. 작성자 있을 때
            if (author != null) {
                if (schedule.getAuthor().equals(author)) {
                    // Repository에 있는 값과 입력한값 동일한 지 비교
                    filterList.add(new GetScheduleResponse(
                            schedule.getId(),
                            schedule.getTitle(),
                            schedule.getContents(),
                            schedule.getAuthor(),
                            schedule.getCreatedAt(),
                            schedule.getModifiedAt()
                    ));
                }
            }
            // 4-2. 작성자 없을 때
            else {
                filterList.add(new GetScheduleResponse(
                        schedule.getId(),
                        schedule.getTitle(),
                        schedule.getContents(),
                        schedule.getAuthor(),
                        schedule.getCreatedAt(),
                        schedule.getModifiedAt()
                    ));
                }
            }
        // 5. 응답 반환
        return filterList;
    }

}
