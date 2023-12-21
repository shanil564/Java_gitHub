package com.example.demo.repository;
import com.example.demo.entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ProjectsRepo extends JpaRepository<Projects,Long> {
    List<Projects> findByProjectId(Long projectId);

}
