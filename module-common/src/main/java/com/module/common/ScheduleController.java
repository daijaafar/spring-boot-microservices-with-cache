package com.module.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class ScheduleController {

    @PostMapping("schedule")
    public void updateSchedule(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestParam Boolean isOpen) {
        OperationScheduleVO vo = new OperationScheduleVO();
        vo.setSchedule(date);
        vo.setIsOpen(isOpen);
        dao.save(vo);
        publisher.publishSchedule(vo);

        ObjectMapper objectMapper = new ObjectMapper();
        String object = null;
        try {
            object = objectMapper.writeValueAsString(dao.findAll());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(object);
    }

    @Autowired
    private OperationScheduleDAO dao;

    @Autowired
    private Publisher publisher;

}
