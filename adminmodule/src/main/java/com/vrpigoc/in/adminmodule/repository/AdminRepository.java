package com.vrpigoc.in.adminmodule.repository;

import com.vrpigoc.in.adminmodule.entities.AdminEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Long>{

}
