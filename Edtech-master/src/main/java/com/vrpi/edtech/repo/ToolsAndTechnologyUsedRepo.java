package com.vrpi.edtech.repo;

import com.vrpi.edtech.entity.ToolsAndTechnologyUsedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolsAndTechnologyUsedRepo extends JpaRepository<ToolsAndTechnologyUsedEntity, Long> {
}
