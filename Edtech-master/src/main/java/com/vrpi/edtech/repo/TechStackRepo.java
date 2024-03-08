package com.vrpi.edtech.repo;
import com.vrpi.edtech.entity.TechStackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechStackRepo extends JpaRepository<TechStackEntity, Long> {
}
