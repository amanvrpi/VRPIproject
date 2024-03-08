package com.vrpi.edtech.repo;

import com.vrpi.edtech.entity.CourseContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseContentRepo extends JpaRepository<CourseContentEntity, Long> {
}
