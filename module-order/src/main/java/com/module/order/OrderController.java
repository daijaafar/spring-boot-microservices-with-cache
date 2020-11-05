package com.module.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class OrderController {

    private Logger logger = LoggerFactory.getLogger(OrderController.class);

    @GetMapping("isOpen")
    public ResponseEntity<OperationScheduleVO> isOpen(
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date)
        throws InterruptedException {

        if (date == null) {
            date = LocalDate.now();
        }

        OperationScheduleVO vo = null;
//        for (int i = 0; i < 100; i++) {
//            Thread.sleep(5000);
            vo = service.getOperationScheduleVO(date);
            logger.info(ObjectUtil.toJson(vo));
//        }

        return ResponseEntity.ok(vo);
    }

    @Autowired
    private OperationScheduleService service;

}
