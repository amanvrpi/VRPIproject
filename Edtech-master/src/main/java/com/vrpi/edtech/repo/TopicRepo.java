package com.vrpi.edtech.repo;

import com.vrpi.edtech.entity.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepo extends JpaRepository<TopicEntity, Long> {
}
