package com.vrpi.edtech.repo;

import com.vrpi.edtech.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Courserepo extends JpaRepository<CourseEntity, Long>{
}
