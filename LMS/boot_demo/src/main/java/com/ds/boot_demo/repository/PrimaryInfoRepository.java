package com.ds.boot_demo.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ds.boot_demo.entity.EmployeePrimaryInfo;

public interface PrimaryInfoRepository extends JpaRepository<EmployeePrimaryInfo, Integer> {
     Optional<EmployeePrimaryInfo> findByemployeeid(String employeeId);
}
