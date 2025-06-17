package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.model.LoginLog;

public interface LoginLogRepository extends JpaRepository<LoginLog, Long> {
}
