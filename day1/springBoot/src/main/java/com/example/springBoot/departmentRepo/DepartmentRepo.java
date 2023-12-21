package com.example.springBoot.departmentRepo;
import com.example.springBoot.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {
    List<Department> findByDepartmentName(String departmentName);
}
