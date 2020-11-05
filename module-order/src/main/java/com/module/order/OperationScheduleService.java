package com.module.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@EnableCaching
@EnableScheduling
public class OperationScheduleService {

    private Logger logger = LoggerFactory.getLogger(OperationScheduleService.class);

    private Map<LocalDate, Boolean> map = new LinkedHashMap<>();

    @Cacheable("schedule")
    public OperationScheduleVO getOperationScheduleVO(LocalDate date) {
        if (map.containsKey(date)) {
            return new OperationScheduleVO(date, map.get(date));
        }
        return null;
    }

    public void add(OperationScheduleVO vo) {
        map.put(vo.getSchedule(), vo.getIsOpen());
    }

    @CacheEvict(allEntries = true, value = {"schedule"})
    @Scheduled(fixedDelay = 60 * 60000 , initialDelay = 500)
    public void reportCacheEvict() {
        logger.info("Flush Cache");
    }
}
