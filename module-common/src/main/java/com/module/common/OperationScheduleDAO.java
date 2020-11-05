package com.module.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationScheduleDAO extends JpaRepository<OperationScheduleVO, Integer> {}
