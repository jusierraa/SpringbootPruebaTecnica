package com.example.demo.repositoriy;
import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.model.LoginLog;

public interface LoginLogRepository extends JpaRepository<LoginLog, Long> {
}
