package com.vrpi.edtech.repo;

import com.vrpi.edtech.entity.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepo extends JpaRepository<LessonEntity, Long> {
}
