package com.vrpi.edtech.repo;

import com.vrpi.edtech.entity.ChapterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterRepo extends JpaRepository<ChapterEntity, Long> {
}
