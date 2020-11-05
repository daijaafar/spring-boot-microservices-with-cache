package com.module.common;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "OPERATION_SCHEDULE")
@Getter
@Setter
public class OperationScheduleVO {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

//    @JsonDeserialize(using = LocalDateDeserializer.class)
//    @JsonSerialize(using = LocalDateSerializer.class)
    @Column(name = "SCHEDULE")
    private LocalDate schedule;

    @Column(name = "IS_OPEN")
    private Boolean isOpen;
}
