package com.example.demo.repository;
import com.example.demo.entity.Attendence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface
AttendenceRepo extends JpaRepository<Attendence,Long> {
    List<Attendence> findByDate(LocalDate date);
    List<Attendence> findByEmployeeEmpIdAndDateBetween(Long employeeId, LocalDate startDate, LocalDate endDate);
}
