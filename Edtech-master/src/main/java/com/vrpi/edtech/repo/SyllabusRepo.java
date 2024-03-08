package com.vrpi.edtech.repo;

import com.vrpi.edtech.entity.SyllabusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SyllabusRepo extends JpaRepository<SyllabusEntity, Long>{
}
