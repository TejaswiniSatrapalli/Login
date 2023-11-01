package com.cg.hbm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hbm.entity.Admin;
	
	
@Repository


public interface AdminRepository extends JpaRepository<Admin, Integer>{

	

}
