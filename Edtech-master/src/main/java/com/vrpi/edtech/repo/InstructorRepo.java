package com.vrpi.edtech.repo;

import com.vrpi.edtech.entity.InstructorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepo extends JpaRepository<InstructorEntity, Long> {
}
