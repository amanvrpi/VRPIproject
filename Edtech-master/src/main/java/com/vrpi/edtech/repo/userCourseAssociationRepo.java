package com.vrpi.edtech.repo;

import com.vrpi.edtech.entity.UserCourseAssociation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userCourseAssociationRepo extends JpaRepository<UserCourseAssociation,Long> {
}
