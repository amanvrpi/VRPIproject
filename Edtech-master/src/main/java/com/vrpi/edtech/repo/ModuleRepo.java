package com.vrpi.edtech.repo;

import com.vrpi.edtech.entity.ModuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepo extends JpaRepository<ModuleEntity, Long> {
}
