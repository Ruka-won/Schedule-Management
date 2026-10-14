package com.schedulemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SchedulemanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulemanagementApplication.class, args);
    }

}
