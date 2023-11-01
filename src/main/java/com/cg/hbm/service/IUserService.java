package com.cg.hbm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.hbm.entity.User;

@Service
public interface IUserService {

	User registerUser(User user)throws Exception;
	List<User> getAllUsers();
	User getUserById(int userId);
	User updateUser(int userId);
//	List<User> getUserByState(String state);
//	List<User> getUserByCity (String city);


}
