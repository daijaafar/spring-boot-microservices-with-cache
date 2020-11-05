package com.module.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class Publisher  {

    private final RabbitTemplate rabbitTemplate;

    public Publisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishSchedule(OperationScheduleVO vo) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String object = null;
        try {
            object = objectMapper.writeValueAsString(vo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        rabbitTemplate.convertAndSend("topic-exchange-common", "foo.bar.baz", object);
    }

}
