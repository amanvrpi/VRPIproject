package com.vrpi.edtech.repo;

import com.vrpi.edtech.entity.EducationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationDetailsRepo extends JpaRepository<EducationDetails, Long> {
}
