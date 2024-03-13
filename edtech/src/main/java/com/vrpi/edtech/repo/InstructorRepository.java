package com.vrpi.edtech.repo;


import com.vrpi.edtech.entity.InstructorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructorRepository extends JpaRepository<InstructorEntity, Long> {

    Optional<InstructorEntity> findByEmail(String email);
}