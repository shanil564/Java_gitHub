package com.example.demo.repository;
import com.example.demo.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeesRepo extends JpaRepository<Employees,Long> {
    List<Employees> findByEmpId(Long empId);
}
