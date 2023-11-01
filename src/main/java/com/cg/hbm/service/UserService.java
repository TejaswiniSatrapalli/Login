package com.cg.hbm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hbm.entity.User;
import com.cg.hbm.exceptions.InvalidUserException;
import com.cg.hbm.repository.UserRepository;

@Service

public class UserService implements IUserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User registerUser(User user)throws InvalidUserException {
	
		if(user.getUserName().equals("")) {
			throw new InvalidUserException("User name","User Name is null");
		}
		
		if(user.getEmailId().equals("")) {
			throw new InvalidUserException("Email Id","Email Id cannot be null");
		}
		if(user.getPassword().equals("")) {
			throw new InvalidUserException("Password","Password cannot be null");
		}
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	
//	@Override
//	public List<User> getUserByCity(String searchCity) {
//		//get all users 
//		List<Customer> allUsers = customerRepository.findAll();
//		//Filter user through for loop based on city
//		List<Customer> allUserByCity = new ArrayList<>();
//		for(Customer user : allUsers) {
//			String userCity =user.getAddress().getCity();
//		if(userCity.equals(searchCity)) {
//			allUserByCity.add(user);
//		}
//		}
//		
//		return allUserByCity;
//	}
//	
//	

//	@Override
//	public List<Customer> getUserByState(String searchstate) {
//		
//		List<Customer> allUsers = customerRepository.findAll();
//		List<Customer> allUserByState = new ArrayList<>();
//		for (Customer user: allUsers) {
//			String userState = user.getAddress().getState();
//			if(userState.equals(searchstate)) {
//				allUserByState.add(user);
//			}
//		}
//		return allUserByState;
//	}

	@Override
	public User getUserById(int userId) {
		
		User userFromDB = userRepository.getReferenceById(userId);
		userRepository.getReferenceById(userId);
	
		return userFromDB;
	}

	@Override
	public User updateUser(int userId) {
	
		User updatedUser = userRepository.getReferenceById(userId);
		userRepository.save(updatedUser);
		return updatedUser;
	}

	

}


