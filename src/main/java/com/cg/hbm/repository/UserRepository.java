package com.cg.hbm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hbm.entity.Transaction;
import com.cg.hbm.entity.User;

	
@Repository


public interface UserRepository extends JpaRepository<User, Integer>{

	
//	 List<User>findById(Long userId);
	

}
