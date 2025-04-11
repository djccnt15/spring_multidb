package com.djccnt15.spring_multidb.domain.primary;

import com.djccnt15.spring_multidb.annotations.ScheduledTask;
import com.djccnt15.spring_multidb.db.primary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;

@Slf4j
@ScheduledTask
@RequiredArgsConstructor
public class PrimaryScheduled {
    
    private final UserRepository repository;
    
    @Scheduled(fixedRate = 10, timeUnit = TimeUnit.SECONDS)
    private void primarySchedule() {
        var userList = repository.findAll();
        userList.forEach(it -> log.info(it.toString()));
    }
}
