package com.djccnt15.spring_multidb.domain.secondary;

import com.djccnt15.spring_multidb.annotations.ScheduledTask;
import com.djccnt15.spring_multidb.db.secondary.repository.DataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;

@Slf4j
@ScheduledTask
@RequiredArgsConstructor
public class SecondaryScheduled {
    
    private final DataRepository repository;
    
    @Scheduled(fixedRate = 10, timeUnit = TimeUnit.SECONDS)
    private void secondaryScheduled() {
        var data = repository.findAll();
        data.forEach(it -> log.info(it.toString()));
    }
}
